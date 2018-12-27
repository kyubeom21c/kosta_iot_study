String userName = "";
void setup() {
  Serial.begin(9600);
}
void loop() {
  //userName = "";
  if(Serial.available()){
      userName = Serial.readString();
   }
   Serial.println(userName+100);
   delay(1000);
}
