#include "TFT_eSPI.h"
#include "rpcWiFi.h"
#include <PubSubClient.h>

// Update these with values suitable for your network.
const char *ssid = "SSID";      // your network SSID
const char *password = "password"; // your network password

const char *ID = "Wio-Terminal-Client";  // Name of our device, must be unique
const char *TOPIC = "group9_outTopic";  // Topic to subcribe to
const char *subTopic = "group9_inTopic";  // Topic to subcribe to
const char *server = "broker.emqx.io"; // Server URL

WiFiClient wifiClient;
PubSubClient client(wifiClient);

int buzzer = 0;
int ultrasonicFront = 8;
int ultrasonicBack = 1;

TFT_eSPI tft;
TFT_eSprite spr = TFT_eSprite(&tft);



void setup() {
  WiFi.begin(ssid, password);

  // attempt to connect to Wifi network:
  while (WiFi.status() != WL_CONNECTED)
  {
    Serial.print(".");
    WiFi.begin(ssid, password);
    // wait 1 second for re-trying
    delay(1000);
  }

  client.setServer(server, 1883);
  pinMode(buzzer, OUTPUT);
  pinMode(WIO_BUZZER, OUTPUT);

  tft.begin();
  tft.setRotation(3);
  spr.createSprite(TFT_HEIGHT,TFT_WIDTH);
  Serial.begin(9600); // initialize serial communication

}

void loop() {

  spr.fillSprite(TFT_BLACK);
  spr.setTextSize(2);
  spr.setTextColor(TFT_YELLOW);
  spr.drawString("Distance to Object",55,10);
  spr.drawFastHLine(40,35,240,TFT_DARKGREY);
  spr.setTextColor(TFT_WHITE);
  spr.drawString("- Distance: ",20,50);
  int distanceFront = 0.01723 * readUltrasonicDuration(ultrasonicFront, ultrasonicFront);
  int distanceBack = 0.01723 * readUltrasonicDuration(ultrasonicBack, ultrasonicBack);
  spr.drawNumber(distanceFront,160,50);
  spr.drawString("cm",205,50);
  Serial.println(distanceFront);
  Serial.println(distanceBack);


  if (client.connect(ID)) {
      String data = "distance:front:" + String(distanceFront) + " cm;distance:back:" + String(distanceBack) + " cm";
      client.publish(TOPIC, data.c_str());
    }

  int distance = 0;
  if(distanceFront <= distanceBack){
    distance = distanceFront;
  }else{
    distance = distanceBack;
  }

  if(distance < 50){
    tone(WIO_BUZZER, 1000, 100);
    delay(distance * 20);
  }

  spr.pushSprite(0,0);
}

long readUltrasonicDuration(int triggerPin, int echoPin)
{
  pinMode(triggerPin, OUTPUT);  // Clear the trigger
  digitalWrite(triggerPin, LOW);
  delayMicroseconds(2);
  // Sets the trigger pin to HIGH state for 10 microseconds
  digitalWrite(triggerPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(triggerPin, LOW);
  pinMode(echoPin, INPUT);
  // Reads the echo pin, and returns the sound wave travel time in microseconds
  return pulseIn(echoPin, HIGH);
}
