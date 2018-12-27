#include <SimpleTimer.h>
//Download github
//https://github.com/schinken/SimpleTimer
//downloadzip >> 스케치 >> 라이브러리포함 >> .zip라이브러리추가
SimpleTimer timer;
int count;
void setup() {
  Serial.begin(9600);
  Serial.println("setup()...");
  timer.setInterval(3000,plus);
  timer.setInterval(5000,minus);
}
void plus(){
  Serial.println("Good..."); 
  count++;
}
void minus(){
  Serial.println("Good..."); 
  count--;
}

void loop() {
  Serial.print(count);
  Serial.println("  loop()...");
  timer.run();
  
  delay(1000);
}
