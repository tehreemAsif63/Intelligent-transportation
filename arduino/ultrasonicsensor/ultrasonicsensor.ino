
#include "Ultrasonic.h"

Ultrasonic ultraEast(D0);
int ultraNorth = 1;


void setup() {

}

void loop() {

carOnEast();

}

void carOnEast(){
  if(flag >= 20 && flag < 37){
    double distance = ultraEast.MeasureInCentimeters();
    
    if(distance < 10){
       if(!isNewCarEast){ //To avoid duplicate counting
          isNewCarEast = true;
          tone(WIO_BUZZER, 100, 1000);
          countEastCar ++;
          if (client.connect(ID)) {
            String data = "east:car:" + String(countEastCar) + ";north:car:0";
            client.publish(TOPIC, data.c_str());
          }
          flag += 4;
          if(flag > 37){
            flag = 37;
          }
      }
      spr.drawString("Car Come from the east.",20,100);
      //Serial.println("Car Come from the east.");

    }
    else{
      isNewCarEast = false;
    }
  }
}

