// Defining the pins for the LED lights

//Defining the pins in Wio terminal
//const int redEast = 2;
//const int yellowEast = 3;
//const int greenEast = 4;

//const int redNorth = 5;
//const int yellowNorth = 6;
//const int greenNorth = 7;

//Defining the pins in Tinkercad
const int redEast = 12;
const int yellowEast = 10;
const int greenEast = 8;

const int redNorth = 6;
const int yellowNorth = 4;
const int greenNorth = 2;

int flag=0;

void setup() {
  // put your setup code here, to run once:
 
  pinMode(redEast, OUTPUT);
  pinMode(yellowEast, OUTPUT);
  pinMode(greenEast, OUTPUT);

  pinMode(redNorth, OUTPUT);
  pinMode(yellowNorth, OUTPUT);
  pinMode(greenNorth, OUTPUT);

  Serial.begin(9600); // initialize serial communication
}

void loop() {
  
  
  digitalWrite(redNorth, LOW);
  digitalWrite(yellowEast, LOW);
  digitalWrite(redEast, HIGH);
  digitalWrite(greenNorth, HIGH);
  delay(1000);
   
  //Signal on for north-south
  
  digitalWrite(greenNorth, LOW);
  digitalWrite(yellowNorth, HIGH);
  delay(1000); // Wait for 1 second
  //READY FOR BOTH
 
  digitalWrite(yellowNorth, LOW);
  digitalWrite(redNorth, HIGH);
  digitalWrite(redEast, LOW);
  digitalWrite(greenEast, HIGH);  
  delay(1000);
     
  //Signal on for EAST-WEST

  digitalWrite(greenEast, LOW);
  digitalWrite(yellowEast, HIGH);
  delay(1000); // Wait for 1 second
  //READY FOR BOTH
}

