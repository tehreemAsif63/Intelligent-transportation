#include <WiFi.h>
#include <PubSubClient.h>

// Update these with values suitable for your network.
const char *ssid = "SSID";      // your network SSID
const char *password = "password"; // your network password

const char *ID = "Wio-Terminal-Client";  // Name of our device, must be unique
const char *SUB_TOPIC = "BuzzerButtonCommand";  // Topic to subscribe to for commands
const char *PUB_TOPIC = "BuzzerButtonStatus";  // Topic to publish status to
const char *server = "broker.emqx.io"; // Server URL


WiFiClient wifiClient;
PubSubClient client(wifiClient);

//initialising pins
int buzzer = 7;
int buzzerState = 0;

void setup() {

  Serial.begin(115200);

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
  client.setCallback(callback);
  client.connect(ID);

  pinMode(buzzer, OUTPUT);
 
}

void loop() {

  client.
#include <WiFi.h>
#include <PubSubClient.h>

// Update these with values suitable for your network.
const char *ssid = "SSID";      // your network SSID
const char *password = "password"; // your network password

const char *ID = "Wio-Terminal-Client";  // Name of our device, must be unique
const char *SUB_TOPIC = "BuzzerButtonCommand";  // Topic to subscribe to for commands
const char *server = "broker.emqx.io"; // Server URL


WiFiClient wifiClient;
PubSubClient client(wifiClient);

//initialising pins
int buzzer = 7;
int buzzerState = 0;

void setup() {

  Serial.begin(115200);

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
  client.setCallback(callback);
  client.subscribe(SUB_TOPIC);

  pinMode(buzzer, OUTPUT);

 
}

void loop() {
  client.loop();
}

void play(){
  if(buzzerState == 0){
       noTone(buzzer);
       Serial.println("Buzzer off");
    }

  else if(buzzerState==1){
    Serial.println("Buzzzer on...finding car");
    tone(buzzer, 1000);
    delay(1000);
    tone(buzzer, 2000);
    delay(1000);
    noTone(buzzer);
  }
   
} 

void callback(char* topic, byte* payload, unsigned int length) {
  // Convert payload to a string
  char message[length + 1];
  for (int i = 0; i < length; i++) {
    message[i] = (char)payload[i];
  }
  message[length] = '\0';

    Serial.print("Message received: ");
    Serial.println(message);
  
  // Check if message is "stopbuzzer"
  if (strcmp(message, "stopBuzzer") == 0) {
    // Set buzzer state to 0 (buzzer is not playing)
    buzzerState = 0;
    play();
  }
  
  // Check if message is "playbuzzer"
  else if (strcmp(message, "playBuzzer") == 0) {
    // Set buzzer state to 1 (buzzer is playing)
    buzzerState = 1;
    play();
  }
}