#define RELAY 2
//Relay제어
void setup(){
  Serial.begin(9600);
  pinMode(RELAY ,OUTPUT);
}


void loop(){
  digitalWrite(RELAY,HIGH);
  delay(2000);
  digitalWrite(RELAY,LOW);
  delay(1000);
}
