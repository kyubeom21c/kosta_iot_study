#include <Servo.h>
#define PIN 7
Servo servo;
void setup() {
  Serial.begin(9600);
  Serial.println("setup()...");

  servo.attach(PIN);
}
void loop() {
  Serial.println("loop()...");
  servo.write(180);
  delay(1000);
  servo.write(0);
  delay(1000);
}
