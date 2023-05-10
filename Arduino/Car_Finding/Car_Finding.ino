//initialising pins
//tinkercad pins
int buzzer = 7;

void setup() {
  pinMode(buzzer, OUTPUT);
}

void loop() {
  // Play different alarm sounds

  tone(buzzer, 1000);
  delay(1000);
  
  tone(buzzer, 2000);
  delay(1000);

  noTone(buzzer);
  delay(1000);
}