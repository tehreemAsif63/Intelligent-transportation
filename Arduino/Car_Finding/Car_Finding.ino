//initialising pins
//tinkercad pins
int buzzerPin = 7;
bool isPlaying= false;

void setup() {
  pinMode(buzzerPin, OUTPUT);
  Serial.begin(9600);
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

  if (Serial.available() > 0) { // check if there are any incoming serial commands
    char command = Serial.read(); // read the command
    if (command == 'p') { // play tone command
      if (!isPlaying) { // check if the tone is not already playing
        isPlaying = true;
        tone(buzzerPin, 1000); // start playing tone
        delay(150); 
        noTone(buzzerPin); 
        delay(150);

        tone(buzzerPin, 2000); 
        delay(150); 
        noTone(buzzerPin); 
        delay(150); 
      }
      
    } else if (command == 's') { // stop tone command
      if (isPlaying) { // check if the tone is currently playing
        isPlaying = false;
        noTone(buzzerPin); // stop playing tone
      }
    }
  }
}

 