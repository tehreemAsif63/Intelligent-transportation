#include "TFT_eSPI.h"
#include "Ultrasonic.h"


TFT_eSPI tft;
TFT_eSprite spr = TFT_eSprite(&tft);
Ultrasonic ultrasonic(D0);


void setup() {
  tft.begin();
  tft.setRotation(3);
  spr.createSprite(TFT_HEIGHT,TFT_WIDTH);
  pinMode(WIO_BUZZER, OUTPUT);

}
void loop() {

  spr.fillSprite(TFT_BLACK);
  spr.setTextSize(2);
  spr.setTextColor(TFT_YELLOW);
  spr.drawString("Distance to Object",55,10);
  spr.drawFastHLine(40,35,240,TFT_DARKGREY);
  spr.setTextColor(TFT_WHITE);
  spr.drawString("- Distance: ",20,50);
  double distance = ultrasonic.MeasureInCentimeters();
  spr.drawNumber(distance,160,50);
  spr.drawString("cm",205,50);

  if(distance < 50){
    tone(WIO_BUZZER, 1000, 100);
    delay(distance * 20);
  }
  spr.pushSprite(0,0);
}