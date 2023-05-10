//initialising pins
//tinkercad pins
int buzzerPin = 7;

void setup() {
  pinMode(buzzerPin, OUTPUT);
}

void loop() {
  // Play police siren tone
  
  tone(buzzerPin, 1000); 
  delay(150); 
  noTone(buzzerPin); 
  delay(150);

  tone(buzzerPin, 2000); 
  delay(150); 
  noTone(buzzerPin); 
  delay(150); 
}
  
 