byte digital[3][7] = {
  {0,0,0,0,0,0,1},//0
  {1,0,0,1,1,1,1},//1
  {0,0,1,0,0,1,0} //2
};

void setup() {
  Serial.begin(9600);
  Serial.println("setup()...");
  pinMode(2,OUTPUT);//a
  pinMode(3,OUTPUT);//b
  pinMode(4,OUTPUT);//c
  pinMode(5,OUTPUT);//d
  pinMode(6,OUTPUT);//e
  pinMode(7,OUTPUT);//f
  pinMode(8,OUTPUT);//g
}

void loop() {
  Serial.println("loop()...");
  int pin = 2;
  for(int i=0;i<7;i++){
    digitalWrite(pin+i,digital[1][i]);
  }
  delay(1000);
}
