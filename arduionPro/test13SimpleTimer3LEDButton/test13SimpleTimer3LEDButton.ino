#include <SimpleTimer.h>
#define BUTTON 2
#define LED 8
//Download github
//https://github.com/schinken/SimpleTimer
//downloadzip >> 스케치 >> 라이브러리포함 >> .zip라이브러리추가
SimpleTimer timer;
int mState=0;
void setup() {
  Serial.begin(9600);
  Serial.println("setup()...");
  pinMode(LED,OUTPUT);
  pinMode(BUTTON,INPUT);
}
void ledON(){
  digitalWrite(LED,HIGH);
  delay(1000);
  digitalWrite(LED,LOW);
  mState=0;
}
void loop() {
  Serial.println("loop()...");
  Serial.println(digitalRead(BUTTON));
  if(digitalRead(BUTTON) && mState==0){
    timer.setTimeout(3000,ledON);
    Serial.println("Pressed Button..");
    mState=1;
  }
  timer.run();
  delay(1000);
}
