#define LED 3
int reg = 0;
void setup() {
  Serial.begin(9600);
}
void loop() {
  reg = analogRead(A0);
  Serial.println(reg);
  delay(100);
  //mission : 가변저항 값을 이용하여 
  //LED 밝기 조절하기.
  //reg /= 4;
  //analogWrite(LED,reg);
  Serial.println(map(reg,0,1023,0,255));
  analogWrite(LED,map(reg,0,1023,0,255));
}
