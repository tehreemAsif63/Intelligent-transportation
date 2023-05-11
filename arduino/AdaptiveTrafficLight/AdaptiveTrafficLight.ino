#include "TFT_eSPI.h"

// Defining the pins in Wio terminal
// Defining the pins for the LED lights
const int redEast = 2;
const int yellowEast = 3;
const int greenEast = 4;

const int redNorth = 5;
const int yellowNorth = 6;
const int greenNorth = 7;

int maxFlag = 40;
int flag = 0;

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
  
  Serial.begin(9600); 

  tft.begin();
  tft.setRotation(3);
  spr.createSprite(TFT_HEIGHT,TFT_WIDTH);

}

void loop() {

  if(flag >= maxFlag){
      flag = 0;
  }

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

    spr.setTextColor(TFT_GREEN);
    spr.drawString("East:  Green light: ",20,50);
    spr.drawNumber(17 - flag,260,50);
    spr.setTextColor(TFT_RED);
    spr.drawString("North: Red light: ",20,75);
    spr.drawNumber(20 - flag,260,75);

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
    spr.drawNumber(20 - flag,260,50);
    spr.setTextColor(TFT_RED);
    spr.drawString("North: Red light: ",20,75);
    spr.drawNumber(20 - flag,260,75);

  }
  
  if(flag >= maxFlag / 2 && flag < maxFlag - 3){
    digitalWrite(redEast, HIGH);
    digitalWrite(yellowEast, LOW);
  	digitalWrite(greenEast, LOW);

    digitalWrite(redNorth, LOW);
    digitalWrite(yellowNorth, LOW);
    digitalWrite(greenNorth, HIGH);

    spr.setTextColor(TFT_RED);
    spr.drawString("East:  Red light: ",20,50);
    spr.drawNumber(40 - flag,260,50);
    spr.setTextColor(TFT_GREEN);
    spr.drawString("North: Green light: ",20,75);
    spr.drawNumber(37 - flag,260,75);
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
    spr.drawNumber(40 - flag,260,50);
    spr.setTextColor(TFT_YELLOW);
    spr.drawString("North: Yellow light: ",20,75);
    spr.drawNumber(40 - flag,260,75);
  }
}


