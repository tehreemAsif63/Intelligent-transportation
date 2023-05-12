
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
    }
    else{
      isNewCarEast = false;
    }
  }
}

