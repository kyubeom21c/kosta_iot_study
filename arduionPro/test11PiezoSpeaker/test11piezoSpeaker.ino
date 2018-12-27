#include "pitches.h"
#define SPEKER 8

void setup() {
  Serial.begin(9600);
  Serial.println("setup()...");

}
void loop() {
  Serial.println("loop()...");
  tone(SPEKER,NOTE_GS3,1000);
  delay(1000);
  noTone(SPEKER);
  delay(1000);
}
