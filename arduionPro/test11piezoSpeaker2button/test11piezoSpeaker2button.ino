#include "pitches.h"
#define SPEKER 8
#define BUTTON 2
void setup() {
  Serial.begin(9600);
  Serial.println("setup()...");
  pinMode(BUTTON,INPUT);
}
void loop() {
  Serial.println("loop()...");
  Serial.println(digitalRead(BUTTON));
  if(digitalRead(BUTTON)){
    tone(SPEKER,NOTE_GS3,1000);
  }else{
    noTone(SPEKER);
  }
  //delay(1000);
}
