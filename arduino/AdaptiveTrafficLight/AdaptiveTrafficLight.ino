#include "TFT_eSPI.h"

// Defining the pins in Wio terminal
// Defining the pins for the LED lights
const int redEast = 2;
const int yellowEast = 3;
const int greenEast = 4;

const int redNorth = 5;
const int yellowNorth = 6;
const int greenNorth = 7;

// Defining the pins for the ultrasonic sensors
int ultraEast = 8;
int ultraNorth = 1;

int maxFlag = 40;
int flag = 0;
int tempFlag = -1;
int countEastCar = 0;
int countNorthCar = 0;
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
  
  pinMode(redEast, OUTPUT);
  pinMode(yellowEast, OUTPUT);
  pinMode(greenEast, OUTPUT);

  pinMode(redNorth, OUTPUT);
  pinMode(yellowNorth, OUTPUT);
  pinMode(greenNorth, OUTPUT);
  
  pinMode(WIO_BUZZER, OUTPUT);

  Serial.begin(9600); 

  tft.begin();
  tft.setRotation(3);
  spr.createSprite(TFT_HEIGHT,TFT_WIDTH);

}

void loop() {

  if(flag >= maxFlag){
      flag = 0;
  }

  carOnEast();
  carOnNorth();

  userControl();
  adminControl();

  trafficLight();
  
  delay(1000);
  flag++;

  printTitleOnWioTerminal();
  spr.pushSprite(0,0);//print on Wio terminal

}

void trafficLight(){
  if(flag < maxFlag / 2 - 3){
    digitalWrite(redEast, LOW);
    digitalWrite(yellowEast, LOW);
  	digitalWrite(greenEast, HIGH);

    digitalWrite(redNorth, HIGH);
    digitalWrite(yellowNorth, LOW);
    digitalWrite(greenNorth, LOW);

    countEastCar = 0;

    spr.setTextColor(TFT_GREEN);
    spr.drawString("East:  Green light: ",20,50);
    spr.drawNumber(maxFlag / 2 - 3 - flag,260,50);
    spr.setTextColor(TFT_RED);
    spr.drawString("North: Red light: ",20,75);
    spr.drawNumber(maxFlag / 2 - flag,260,75);

  }
  
  if(flag >= maxFlag / 2 - 3 && flag < maxFlag / 2){
    digitalWrite(redEast, LOW);
    digitalWrite(yellowEast, HIGH);
  	digitalWrite(greenEast, LOW);

    digitalWrite(redNorth, HIGH);
    digitalWrite(yellowNorth, LOW);
    digitalWrite(greenNorth, LOW);

    spr.setTextColor(TFT_YELLOW);
    spr.drawString("East:  Yellow light:",20,50);
    spr.drawNumber(maxFlag / 2 - flag,260,50);
    spr.setTextColor(TFT_RED);
    spr.drawString("North: Red light: ",20,75);
    spr.drawNumber(maxFlag / 2 - flag,260,75);

  }
  
  if(flag >= maxFlag / 2 && flag < maxFlag - 3){
    digitalWrite(redEast, HIGH);
    digitalWrite(yellowEast, LOW);
  	digitalWrite(greenEast, LOW);

    digitalWrite(redNorth, LOW);
    digitalWrite(yellowNorth, LOW);
    digitalWrite(greenNorth, HIGH);

    countNorthCar = 0;

    spr.setTextColor(TFT_RED);
    spr.drawString("East:  Red light: ",20,50);
    spr.drawNumber(maxFlag - flag,260,50);
    spr.setTextColor(TFT_GREEN);
    spr.drawString("North: Green light: ",20,75);
    spr.drawNumber(maxFlag - 3 - flag,260,75);
  }
  
  if(flag >= maxFlag - 3 && flag < maxFlag){
    digitalWrite(redEast, HIGH);
    digitalWrite(yellowEast, LOW);
  	digitalWrite(greenEast, LOW);

    digitalWrite(redNorth, LOW);
    digitalWrite(yellowNorth, HIGH);
    digitalWrite(greenNorth, LOW);

    spr.setTextColor(TFT_RED);
    spr.drawString("East:  Red light: ",20,50);
    spr.drawNumber(maxFlag - flag,260,50);
    spr.setTextColor(TFT_YELLOW);
    spr.drawString("North: Yellow light: ",20,75);
    spr.drawNumber(maxFlag - flag,260,75);
  }
}

void carOnEast(){
	if(flag >= maxFlag / 2 && flag < maxFlag - 3){
    double distance = 0.01723 * readUltrasonicDuration(ultraEast, ultraEast);
  	if(distance < 10){ 
      if(!isNewCarEast){ //To avoid duplicate counting
          isNewCarEast = true;
          tone(WIO_BUZZER, 100, 1000);
          countEastCar ++;
          flag += 4;
          if(flag > maxFlag - 3){
          	flag = maxFlag - 3;
          }
      }
      spr.drawString("Car Come from the east.",20,100);
    }else{
    	isNewCarEast = false;
    }
  }
}

void carOnNorth(){
	if(flag >= 0 && flag < maxFlag / 2 - 3){
    double distance = 0.01723 * readUltrasonicDuration(ultraNorth, ultraNorth);
  	if(distance < 10){ //To avoid duplicate counting
      if(!isNewCarNorth){
        isNewCarNorth = true;
        tone(WIO_BUZZER, 100, 1000);
        countNorthCar ++;
        spr.drawString("Car Come from the north.",20,100);
        flag += 5;
        if(flag > maxFlag / 2 - 3 && flag < maxFlag - 3){
          flag = maxFlag / 2 - 3;
        }
      }
      spr.drawString("Car Come from the north.",20,100);
    }else{
    	isNewCarNorth = false;
    }
  }
}

void userControl(){
  if(userType < 2){
    flag += 3;
    userType = 0;
    if(flag > maxFlag / 2 - 3 && flag < maxFlag -3){
      flag = maxFlag / 2 - 3;
    }
    if(flag > maxFlag - 3){
      flag = maxFlag - 3;
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
      flag = maxFlag / 2;
    }

    if(isExchange){
      flag += maxFlag / 2;
      if(flag >= maxFlag / 2 && flag < maxFlag){
        flag = maxFlag / 2;
      }
      isExchange = false;
    }
  }
}


long readUltrasonicDuration(int triggerPin, int echoPin){
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

void printTitleOnWioTerminal() {
  
  spr.fillSprite(TFT_BLACK);
  spr.setTextSize(2);
  spr.setTextColor(TFT_WHITE);
  spr.drawString("Traffic Light Time",55,10);
  spr.drawFastHLine(40,35,240,TFT_DARKGREY);

}