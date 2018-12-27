#define RED 9
#define GREEN 10
#define BLUE 11
//PWM(Pulse Width Modulation)
//디지털 핀 전압의 LOW or HIGH 상태인 
//시간을 조절해서 아날로그 신호를 구현.
void setup() { 
}
void loop() {
  analogWrite(RED,255);
  analogWrite(GREEN,50);
  analogWrite(BLUE,0);
  delay(1000);
}
