#define RED 9
#define GREEN 10
#define BLUE 11
//PWM(Pulse Width Modulation)
//디지털 핀 전압의 LOW or HIGH 상태인 
//시간을 조절해서 아날로그 신호를 구현.
void setup() { 
  randomSeed(analogRead(0));
}
void loop() {
  analogWrite(RED,random(255));
  analogWrite(GREEN,random(255));
  analogWrite(BLUE,random(255));
  delay(1000);
}
