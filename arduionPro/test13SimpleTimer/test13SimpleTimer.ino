#include <SimpleTimer.h>
//Download github
//https://github.com/schinken/SimpleTimer
//downloadzip >> 스케치 >> 라이브러리포함 >> .zip라이브러리추가
SimpleTimer timer;

void setup() {
  Serial.begin(9600);
  Serial.println("setup()...");
  timer.setTimeout(3000,testPrint);
}

void testPrint(){
  Serial.println("Good..."); 
}

void loop() {
  Serial.println("loop()...1");
  timer.run();
  Serial.println("loop()...2");
  
  delay(1000);
}
