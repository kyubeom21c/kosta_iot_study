#define LT 2
//Line Tracking Sensor
//적외선 감지센서도 동일
void setup(){
  Serial.begin(9600);
  pinMode(LT,INPUT);
}


void loop(){
  Serial.println(LOW == digitalRead(LT));
  if(LOW == digitalRead(LT)){
    Serial.println("Detected");
  }else{
    Serial.println("Not");
  }
  delay(100);
}
