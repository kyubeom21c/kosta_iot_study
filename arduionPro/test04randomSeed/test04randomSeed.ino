void setup() {
  Serial.begin(9600);

  //random함수 호출전에 난수 초기화
  randomSeed(analogRead(0));
}
void loop() {
  Serial.println(random(255));  
  delay(1000);   
}
