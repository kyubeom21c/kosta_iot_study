#define TRIG 2
#define ECHO 3
void setup() {
  Serial.begin(9600);
  Serial.println("setup()...");
  pinMode(TRIG,OUTPUT);
  pinMode(ECHO,INPUT);
}
void loop() {
  Serial.println("loop()...");
  digitalWrite(TRIG,LOW);
  delayMicroseconds(2);
  digitalWrite(TRIG,HIGH);
  delayMicroseconds(10);
  digitalWrite(TRIG,LOW);
  
  float distance = (float)(340*pulseIn(ECHO,HIGH)/10000/2);
  if(distance>=20 || distance < 0){
    Serial.println("Out of range...");
  }else{
    Serial.println(distance);
  }
  
  delay(500);
}
