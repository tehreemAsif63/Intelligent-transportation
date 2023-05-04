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

//Defining the pins in Wio terminal
// Defining the pins for the LED lights
const int redEast = 2;
const int yellowEast = 3;
const int greenEast = 4;

const int redNorth = 5;
const int yellowNorth = 6;
const int greenNorth = 7;

// Defining the pins for the PIR sensors
#define pirEast 0
const int pirNorth = 1;

//Defining the pins in Tinkercad
//const int redEast = 12;
//const int yellowEast = 10;
//const int greenEast = 8;

//const int redNorth = 6;
//const int yellowNorth = 4;
//const int greenNorth = 2;

//const int pirEast = 13;
//const int pirNorth = 3;

int flag = 0;
int tempFlag = -1;
bool isNewCarEast = false; //To avoid duplicate counting
bool isNewCarNorth = false; //To avoid duplicate counting

int userType = 0; //0 is no case; 1 is general user; 2 is admin user
int whichGo = 0; // 0 is no case; 1 is east-west; 2 is north-south
bool isRenew = false; // true is renew to original state
bool isExchange = false; // true is immediately change the traffic light status on both sides

//print on Wio terminal
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
  client.setCallback(callback);
 
  pinMode(redEast, OUTPUT);
  pinMode(yellowEast, OUTPUT);
  pinMode(greenEast, OUTPUT);

  pinMode(redNorth, OUTPUT);
  pinMode(yellowNorth, OUTPUT);
  pinMode(greenNorth, OUTPUT);
  
  pinMode(pirEast, INPUT);
  pinMode(pirNorth, INPUT);

  pinMode(WIO_BUZZER, OUTPUT);
  Serial.begin(9600); // initialize serial communication

  tft.begin();
  tft.setRotation(3);
  spr.createSprite(TFT_HEIGHT,TFT_WIDTH);
}

void loop() {

  client.loop();
  client.subscribe(subTopic);
  

  printTitleOnWioTerminal();

  if(flag >= 40){
  	flag = 0;
  }
  
  carOnEast();
  
  //carOnNorth();
  
  //userControl();
  adminControl();
  
  trafficLight();
  
  delay(1000);
  flag++;
  
  spr.pushSprite(0,0);//print on Wio terminal
}

void carOnEast(){
	if(flag >= 20 && flag < 37){
  	if(digitalRead(pirEast) == HIGH){ 
      if(!isNewCarEast){ //To avoid duplicate counting
          isNewCarEast = true;
          tone(WIO_BUZZER, 100, 1000);
          flag += 4;
          if(flag > 37){
          	flag = 37;
          }
      }
      spr.drawString("Car Come from the east.",20,100);
      //Serial.println("Car Come from the east.");
    }else{
    	isNewCarEast = false;
    }
  }
}

void carOnNorth(){
	if(flag >= 0 && flag < 17){
  	if(digitalRead(pirNorth) == HIGH){ //To avoid duplicate counting
      if(!isNewCarNorth){
          isNewCarNorth = true;
          tone(WIO_BUZZER, 100, 1000);
          spr.drawString("Car Come from the north.",20,100);
          flag += 4;
          if(flag > 17 && flag < 37){
          	flag = 17;
          }
      }
      spr.drawString("Car Come from the north.",20,100);
      //Serial.println("Car Come from the north.");
    }else{
    	isNewCarNorth = false;
    }
  }
}

void trafficLight(){
  if(flag < 17){
  	digitalWrite(greenEast, HIGH);
    digitalWrite(redNorth, HIGH);
    digitalWrite(yellowNorth, LOW);
    digitalWrite(redEast, LOW);

    if (client.connect(ID)) {
      String data = "east:green:" + String(17 - flag) + ".north:red:" + String(20 - flag);
      client.publish(TOPIC, data.c_str());
    }
    spr.setTextColor(TFT_GREEN);
    spr.drawString("East:  Green light: ",20,50);
    spr.drawNumber(17 - flag,260,50);
    spr.setTextColor(TFT_RED);
    spr.drawString("North: Red light: ",20,75);
    spr.drawNumber(20 - flag,260,75);

    //Serial.print("East:  Green light: ");
    //Serial.println(17 - flag);
    //Serial.print("North: Red light: ");
    //Serial.println(20 - flag);
  }
  
  if(flag >= 17 && flag < 20){
  	digitalWrite(yellowEast, HIGH);
    digitalWrite(greenEast, LOW);

    if (client.connect(ID)) {
      String data = "east:yellow:" + String(20 - flag) + ".north:red:" + String(20 - flag);
      client.publish(TOPIC, data.c_str());
    }
    
    spr.setTextColor(TFT_YELLOW);
    spr.drawString("East:  Yellow light:",20,50);
    spr.drawNumber(20 - flag,260,50);
    spr.setTextColor(TFT_RED);
    spr.drawString("North: Red light: ",20,75);
    spr.drawNumber(20 - flag,260,75);

    //Serial.print("East:  Yellow light: ");
    //Serial.println(20 - flag);
    //Serial.print("North: Red light: ");
    //Serial.println(20 - flag);
  }
  
  if(flag >= 20 && flag < 37){
  	digitalWrite(redEast, HIGH);
    digitalWrite(greenNorth, HIGH);
    digitalWrite(yellowEast, LOW);
    digitalWrite(redNorth, LOW);

    if (client.connect(ID)) {
      String data = "east:red:" + String(40 - flag) + ".north:green:" + String(37 - flag);
      client.publish(TOPIC, data.c_str());
    }

    spr.setTextColor(TFT_RED);
    spr.drawString("East:  Red light: ",20,50);
    spr.drawNumber(40 - flag,260,50);
    spr.setTextColor(TFT_GREEN);
    spr.drawString("North: Green light: ",20,75);
    spr.drawNumber(37 - flag,260,75);
    
    //Serial.print("East:  Red light: ");
    //Serial.println(40 - flag);
    //Serial.print("North: Green light: ");
    //Serial.println(37 - flag);
  }
  
  if(flag >= 37 && flag < 40){
    digitalWrite(yellowNorth, HIGH);
    digitalWrite(greenNorth, LOW);

    if (client.connect(ID)) {
      String data = "east:red:" + String(40 - flag) + ".north:yellow:" + String(40 - flag);
      client.publish(TOPIC, data.c_str());
    }

    spr.setTextColor(TFT_RED);
    spr.drawString("East:  Red light: ",20,50);
    spr.drawNumber(40 - flag,260,50);
    spr.setTextColor(TFT_YELLOW);
    spr.drawString("North: Yellow light: ",20,75);
    spr.drawNumber(40 - flag,260,75);
    
    //Serial.print("East:  Red light: ");
    //Serial.println(40 - flag);
    //Serial.print("North: Yellow light: ");
    //Serial.println(40 - flag);
  }
}

void userControl(){
  if(userType < 2){
    flag += 3;
    userType = 0;
    if(flag > 17 && flag < 37){
      flag = 17;
    }
    if(flag > 37){
      flag = 37;
    }
  }
}
void adminControl(){
  if(userType == 2){
    if(isRenew){
      whichGo = 0;
      flag = tempFlag;
      isRenew = !isRenew;
    }
    Serial.println("Is operation");
    if(whichGo == 1){
      if(tempFlag == -1){
          tempFlag = flag;
      }
      flag = 0;
    }

    if(whichGo == 2){
      if(tempFlag == -1){
          tempFlag = flag;
      }
      flag = 20;
    }

    if(isExchange){
      flag += 20;
      if(flag >= 20 && flag < 40){
        flag = 20;
      }
      isExchange = false;
    }
  }
}

void printTitleOnWioTerminal() {
  
  spr.fillSprite(TFT_BLACK);
  spr.setTextSize(2);
  spr.setTextColor(TFT_WHITE);
  spr.drawString("Traffic Light Time",55,10);
  spr.drawFastHLine(40,35,240,TFT_DARKGREY);

}

void callback(char* topic, byte* payload, unsigned int length) {
  for (int i=0;i<length;i++) {
    Serial.print((char)payload[i]);
  }
  Serial.println();
  
  if(payload[0]-48 == 1){
    userType = payload[0]-48;
    userControl();
  }
  if(payload[0]-48 == 2){
    userType = 2;
    whichGo = payload[1] - 48;
    
    if(payload[2]-48 == 1){
      isRenew = true;
    }
    if(payload[3]-48 == 1){
      isExchange = true;
    }
    adminControl();
  }
  
  
}
