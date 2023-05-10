int userType = 0; //0 is no case; 1 is general user; 2 is admin user
int whichGo = 0; // 0 is no case; 1 is east-west; 2 is north-south
bool isRenew = false; // true is renew to original state
bool isExchange = false; // true is immediately change the traffic light status on both sides

void setup() {
}

void loop() {
userControl();
adminControl();
}

void userControl(){
  if(userType < 2){
    flag += 3;
    userType = 0;
    if(flag > 17 && flag < 37){
      flag = 17;
    }
    if(flag > 37){
      flag = 37;
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
  }
  Serial.println("Is operation");
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
      flag = 20;
    }
     if(isExchange){
      flag += 20;
      if(flag >= 20 && flag < 40){
        flag = 20;
      }
      isExchange = false;
    }
} 