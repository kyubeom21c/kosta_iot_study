int su;
void setup() {
  Serial.begin(9600);
}
void loop() {
  if(Serial.available()){
    su=Serial.read();
    Serial.println((char)su);
    if(su=='1'){
     Serial.write("\n su One \n");
    }
    if(su=='2'){
     Serial.write("\n su Two \n");
    }  
  }
  
}
