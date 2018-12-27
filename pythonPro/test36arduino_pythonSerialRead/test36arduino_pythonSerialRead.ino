int count;
void setup(){
  Serial.begin(9600);
  //python에서 요구하는 데이터가 아닌 출력문은 제거
  //Serial.println("setup()...");
}


void loop(){
  //python에서 요구하는 데이터가 아닌 출력문은 제거
  //Serial.println("loop()...");
  Serial.println(count++);
  delay(1000);
}
