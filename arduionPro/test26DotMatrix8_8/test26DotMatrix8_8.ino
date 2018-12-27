
void setup(){
  Serial.begin(9600);
  pinMode(2,OUTPUT);
  pinMode(3,OUTPUT);
}


void loop(){
  digitalWrite(2,HIGH);
  Serial.println("loop()...");
 // delay(5000);
  digitalWrite(3,LOW);
  //delay(1000);
}
