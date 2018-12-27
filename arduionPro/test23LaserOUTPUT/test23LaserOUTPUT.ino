#define LASER 2
//레이저 발사기
void setup(){
  Serial.begin(9600);
  pinMode(LASER,OUTPUT);
}


void loop(){
  digitalWrite(LASER,HIGH);
  delay(5000);
  digitalWrite(LASER,LOW);
  delay(1000);
}
