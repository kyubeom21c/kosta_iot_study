char cTemp;
String userName = "";
void setup() {
  Serial.begin(9600);
}
void loop() {
  userName = "";

  while(Serial.available()){
     cTemp = Serial.read();
     userName.concat(cTemp);
   }
   Serial.println(userName+100);
   delay(1000);
}
