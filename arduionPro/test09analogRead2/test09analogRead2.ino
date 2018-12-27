#define LED 3//pwm
int reg = 0;

void setup() {
  Serial.begin(9600);
  Serial.println("setup()...");
}
void loop() {
  Serial.println("loop()...");
  reg = analogRead(A0);
  Serial.println(reg);
  //Serial.println(map(reg,0,1023,0,255));
  //analogWrite(LED,map(reg,0,1023,0,255));
  delay(1000);
}
