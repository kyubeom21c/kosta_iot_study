#define LED 2
char c;
int state = HIGH;
void setup(){
  Serial.begin(9600);
  pinMode(LED,OUTPUT);
}


void loop(){

  delay(1000);
  if(Serial.available()){
    c = Serial.read();
    
  }
  if(c=='1'){
      state = HIGH;
  }
  
  if(c=='0'){
    state = LOW;
    
  }
  digitalWrite(LED,state);
}
