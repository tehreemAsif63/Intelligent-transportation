#include "TFT_eSPI.h"
#include "rpcWiFi.h"
#include <PubSubClient.h>


// update these with values suitable for your network.
const char *ssid = "SSID";      // your network SSID
const char *password = "password"; // your network password

const char *ID = "Wio-Terminal-Client";  // name of our device, must be unique
const char *TOPIC = "group9_outTopic";  // topic to subcribe to
const char *subTopic = "group9_inTopic";  // topic to subcribe to
const char *server = "broker.emqx.io"; // server URL

//wifi and MQTT connection client
WiFiClient wifiClient;
PubSubClient client(wifiClient);
//print on Wio terminal
TFT_eSPI tft;
TFT_eSprite spr = TFT_eSprite(&tft);


// defining the pins in Wio terminal
// defining the pins for the LED lights
const int redEast = 2;
const int yellowEast = 3;
const int greenEast = 4;

const int redNorth = 5;
const int yellowNorth = 6;
const int greenNorth = 7;

// defining the pins for the ultrasonic sensors
int ultraEast = 1;
int ultraNorth = 8;

int maxFlag = 40; // define the max number of flag, maxFlag / 2 is the time that the red light lasts in each direction
int eastYellowPoint = maxFlag / 2 - 3; // yellow light on east is on in this number
int halfMaxFlag = maxFlag / 2; // red light on east is on in this number
int northYellowPoint = maxFlag - 3; // yellow light on north is on in this number
int flag = 0; // flag number represents a traffic light state

int countEastCar = 0; // count the car passing east side
int countNorthCar = 0; // count the car passing north side
bool isNewCarEast = false; // determine if there is double counting on east, to avoid duplicate counting
bool isNewCarNorth = false; // determine if there is double counting on east, to avoid duplicate counting

int userType = 0; // the type of user: 0 is no case; 1 is general user; 2 is admin user
int whichGo = 0; // control which side: 0 is no case; 1 is east-west; 2 is north-south
bool isPause = false; // whether to pause traffic lights: true is immediately pause the traffic light status on both sides
bool isRenew = false; // whether to restore traffic lights: true is restore traffic lights

unsigned long previousMillis_traffic = 0; //previous time
const long interval_traffic = 1000; //interval time is 1 second

void setup() {
  WiFi.begin(ssid, password); //set wi-fi username and password to connect wi-fi
  // attempt to connect to Wi-fi network:
  while (WiFi.status() != WL_CONNECTED){
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

  pinMode(WIO_BUZZER, OUTPUT);

  Serial.begin(9600);

  // draw on the Wio terminal
  tft.begin();
  tft.setRotation(3);
  spr.createSprite(TFT_HEIGHT,TFT_WIDTH);

}

void loop() {

  client.loop();
  client.subscribe(subTopic); // subscribe message, and process the data in the callback function

  unsigned long currentMillis_traffic = millis(); // get the current time
  if (currentMillis_traffic - previousMillis_traffic >= interval_traffic) { // if the time has passed interval time(1 second)

    if(flag >= maxFlag){ // if flag >= maxFlag, let it = 0 to loop
        flag = 0;
    }

    carOnEast(); // count the number of vehicles in the east
    carOnNorth(); // count the number of vehicles in the north

    userControl(); // general user control
    adminControl(); // admin user control

    trafficLight(); // normal traffic light system

    if(!isPause){ // if traffic light is not be paused. if isPause = true, flag should not ++
        flag ++; // flag number represents a traffic light state. flag ++ mean traffic light state --, time remaining of traffic lights --
    }

    printTitleOnWioTerminal();
    spr.pushSprite(0,0);//print on Wio terminal, start drawing at x0, y0

    previousMillis_traffic = currentMillis_traffic; // let previous time = current time, so we can calculate the time for the next second
  }

}

void trafficLight(){ // normal traffic light system
    if(flag < eastYellowPoint){ //before yellow light is green light on east
        greenOnEast();
    }
    if(flag >= eastYellowPoint && flag < halfMaxFlag){ // between the green and red lights is a yellow light on east
        yellowOnEast();
    }
    if(flag >= halfMaxFlag && flag < northYellowPoint){ //before yellow light is green light on north
        greenOnNorth();
    }
    if(flag >= northYellowPoint && flag < maxFlag){ // between the green and red lights is a yellow light on north
        yellowOnNorth();
    }
}

void greenOnEast(){
      // Set the status of each light on east
      digitalWrite(redEast, LOW);
      digitalWrite(yellowEast, LOW);
      digitalWrite(greenEast, HIGH); // the green light is on the east side
      // Set the status of each light on north
      digitalWrite(redNorth, HIGH); // the red light is on the north side
      digitalWrite(yellowNorth, LOW);
      digitalWrite(greenNorth, LOW);
      // setting other lights to low is to avoid that some lights are not turned off during the control process

      countEastCar = 0; // When the east side is green light, vehicles pass, countEastCar = 0

      if (client.connect(ID)) { // if the connection is successful
        // The format of message is:   east:color:time;north:color:time
        String data = "east:green:" + String(eastYellowPoint - flag) + ";north:red:" + String(halfMaxFlag - flag);
        client.publish(TOPIC, data.c_str()); // publish message
      }
      // draw the information in Wio terminal
      spr.setTextColor(TFT_GREEN);
      spr.drawString("East:  Green light: ",20,50);
      spr.drawNumber(eastYellowPoint - flag,260,50);
      spr.setTextColor(TFT_RED);
      spr.drawString("North: Red light: ",20,75);
      spr.drawNumber(halfMaxFlag - flag,260,75);
}

void yellowOnEast(){

    digitalWrite(redEast, LOW);
    digitalWrite(yellowEast, HIGH); // the yellow light is on the east side
  	digitalWrite(greenEast, LOW);

    digitalWrite(redNorth, HIGH); // the red light is on the north side
    digitalWrite(yellowNorth, LOW);
    digitalWrite(greenNorth, LOW);
    // setting other lights to low is to avoid that some lights are not turned off during the control process

    if (client.connect(ID)) { // if the connection is successful
      // The format of message is:   east:color:time;north:color:time
      String data = "east:yellow:" + String(halfMaxFlag - flag) + ";north:red:" + String(halfMaxFlag - flag);
      client.publish(TOPIC, data.c_str()); // publish message
    }
    // draw the information in Wio terminal
    spr.setTextColor(TFT_YELLOW);
    spr.drawString("East:  Yellow light:",20,50);
    spr.drawNumber(halfMaxFlag - flag,260,50);
    spr.setTextColor(TFT_RED);
    spr.drawString("North: Red light: ",20,75);
    spr.drawNumber(halfMaxFlag - flag,260,75);
}

void greenOnNorth(){

    digitalWrite(redEast, HIGH); // the red light is on the east side
    digitalWrite(yellowEast, LOW);
  	digitalWrite(greenEast, LOW);

    digitalWrite(redNorth, LOW);
    digitalWrite(yellowNorth, LOW);
    digitalWrite(greenNorth, HIGH); // the green light is on the north side
    // setting other lights to low is to avoid that some lights are not turned off during the control process

    countNorthCar = 0; // When the north side is green light, vehicles pass, countEastCar = 0

    if (client.connect(ID)) { // if the connection is successful
      // The format of message is:   east:color:time;north:color:time
      String data = "east:red:" + String(maxFlag - flag) + ";north:green:" + String(northYellowPoint - flag);
      client.publish(TOPIC, data.c_str()); // publish message
    }
    // draw the information in Wio terminal
    spr.setTextColor(TFT_RED);
    spr.drawString("East:  Red light: ",20,50);
    spr.drawNumber(maxFlag - flag,260,50);
    spr.setTextColor(TFT_GREEN);
    spr.drawString("North: Green light: ",20,75);
    spr.drawNumber(northYellowPoint - flag,260,75);
}

void yellowOnNorth(){

    digitalWrite(redEast, HIGH); // the red light is on the east side
    digitalWrite(yellowEast, LOW);
  	digitalWrite(greenEast, LOW);

    digitalWrite(redNorth, LOW);
    digitalWrite(yellowNorth, HIGH); // the yellow light is on the north side
    digitalWrite(greenNorth, LOW);

    if (client.connect(ID)) { // if the connection is successful
      // The format of message is:   east:color:time;north:color:time
      String data = "east:red:" + String(maxFlag - flag) + ";north:yellow:" + String(maxFlag - flag);
      client.publish(TOPIC, data.c_str()); // publish message
    }
    // draw the information in Wio terminal
    spr.setTextColor(TFT_RED);
    spr.drawString("East:  Red light: ",20,50);
    spr.drawNumber(maxFlag - flag,260,50);
    spr.setTextColor(TFT_YELLOW);
    spr.drawString("North: Yellow light: ",20,75);
    spr.drawNumber(maxFlag - flag,260,75);
}

void carOnEast(){ // count the number of vehicles on east
	if(flag >= halfMaxFlag && flag < northYellowPoint){ // when red light on the east side, green light on north side
        double distance = 0.01723 * readUltrasonicDuration(ultraEast, ultraEast); // calculate distance. 0.01723 = sonic_speed / 2 / 10000
        if(distance < 10){ //when distance < 10, we think there was a car passing
          if(!isNewCarEast){ //to avoid duplicate counting. Only newly passed vehicles will be counted
              isNewCarEast = true; // set isNewCarEast true, if it is the same car, it will not be counted in the next second
              tone(WIO_BUZZER, 100, 1000); // tone of the prompt
              countEastCar ++; // number of car ++
              if (client.connect(ID)) { // if the connection is successful
                // The format of message is:   east:car:number;north:car:number
                String data = "east:car:" + String(countEastCar) + ";north:car:0";
                client.publish(TOPIC, data.c_str()); // publish message
              }
              flag += 4; // flag + 4 mean The remaining time of the traffic light minus 4 seconds
              if(flag > northYellowPoint){ // if the flag exceeds the start time of the yellow light on north
                flag = northYellowPoint; // it should be returned to the start time of the yellow light.
              } // because it is necessary to ensure that there are three seconds of yellow light between the green light and the red light.
          }
          spr.drawString("Car Come from the east.",20,100); // draw message in the Wio terminal
        }else{ // if distance >= 10, it means that the vehicle has passed or there is no vehicle
            isNewCarEast = false; // set isNewCarEast = false, so that we can continue to counting vehicles
        }
  }
}

void carOnNorth(){ // count the number of vehicles on north
	if(flag >= 0 && flag < eastYellowPoint){ // when red light on the north side, green light on east side
        double distance = 0.01723 * readUltrasonicDuration(ultraNorth, ultraNorth); // calculate distance. 0.01723 = sonic_speed / 2 / 10000
        if(distance < 10){ //when distance < 10, we think there was a car passing
          if(!isNewCarNorth){ //To avoid duplicate counting. Only newly passed vehicles will be counted
            isNewCarNorth = true; // set isNewCarEast true, if it is the same car, it will not be counted in the next second
            tone(WIO_BUZZER, 100, 1000); // tone of the prompt
            countNorthCar ++; // number of car ++
            if (client.connect(ID)) { // if the connection is successful
              // The format of message is:   east:car:number;north:car:number
              String data = "east:car:0;north:car:" + String(countNorthCar);
              client.publish(TOPIC, data.c_str()); // publish message
            }
            flag += 4; // flag + 4 mean The remaining time of the traffic light minus 4 seconds
            if(flag > eastYellowPoint && flag < northYellowPoint){ // if the flag exceeds the start time of the yellow light on east
              flag = eastYellowPoint; // it should be returned to the start time of the yellow light.
            } // because it is necessary to ensure that there are three seconds of yellow light between the green light and the red light.
          }
          spr.drawString("Car Come from the north.",20,100); // draw message in the Wio terminal
        }else{ // if distance >= 10, it means that the vehicle has passed or there is no vehicle
            isNewCarNorth = false; // set isNewCarEast = false, so that we can continue to counting vehicles
        }
  }
}

void userControl(){ // general user control
  if(userType == 1){ // userType == 1 mean user is general user
      flag += 3; // flag + 3 mean The remaining time of the traffic light minus 3 seconds
      userType = 0; // after control, let userType = 0, ensure it is executed only once
      if(flag > eastYellowPoint && flag < halfMaxFlag){ // if the flag exceeds the start time of the yellow light on east
        flag = eastYellowPoint; // it should be returned to the start time of the yellow light.
      } // because it is necessary to ensure that there are three seconds of yellow light between the green light and the red light.
      if(flag > northYellowPoint){ // if the flag exceeds the start time of the yellow light on north
        flag = northYellowPoint; // it should be returned to the start time of the yellow light.
      }
  }
}
void adminControl(){ // admin user control
  if(userType == 2){ // userType == 2 mean user is admin user
    if(isRenew){ // renew is true means restoring traffic lights
      isPause = false; // flag can continue ++. Check the flag ++ section in loop() method
      isRenew = false; // ensure it is executed only once
    }
    if(whichGo == 1){ // it means to let the east side pass
      flag = northYellowPoint; // make sure there is a 3-second yellow light between the green light and the red light in the north to ensure safety
      whichGo = 0; // ensure it is executed only once
    }

    if(whichGo == 2){ // it means to let the north side pass
      flag = eastYellowPoint; // make sure there is a 3-second yellow light between the green light and the red light in the east to ensure safety
      whichGo = 0; // ensure it is executed only once
    }

    //pause control is in loop() method
  }
}

void callback(char* topic, byte* payload, unsigned int length) { // subscribe message from MQTT
  for (int i=0;i<length;i++) {
    Serial.print((char)payload[i]); // print information in console
  }
  Serial.println();
  // payload[0] stands for userType
  // payload[1] stands for whichGo
  // payload[2] stands for isRenew
  // payload[3] stands for isPause

  if(payload[0]-48 == 1){ // payload[0]-48 is to make the type to int
    userType = payload[0]-48; // set user type to general user
    userControl(); // execute general user control
  }
  if(payload[0]-48 == 2){
    userType = 2; // set user type to admin user
    whichGo = payload[1] - 48; // set whichGo
    
    if(payload[2]-48 == 1){ // payload[2]-48 == 1 mean isRenew = true
      isRenew = true;
    }
    if(payload[3]-48 == 1){ // payload[3]-48 == 1 mean isPause = true
      isPause = true;
    }
    adminControl(); // execute general user control
  }
  
}

long readUltrasonicDuration(int triggerPin, int echoPin){ // calculate the time it takes for a sound wave to go from emitting to returning
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

void printTitleOnWioTerminal() { // print title on wio terminal
  
  spr.fillSprite(TFT_BLACK);
  spr.setTextSize(2);
  spr.setTextColor(TFT_WHITE);
  spr.drawString("Traffic Light Time",55,10);
  spr.drawFastHLine(40,35,240,TFT_DARKGREY);

}