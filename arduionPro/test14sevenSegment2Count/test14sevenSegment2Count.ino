byte digital[10][7] = {
  {0,0,0,0,0,0,1},//0
  {1,0,0,1,1,1,1},//1
  {0,0,1,0,0,1,0}, //2
  {0,0,0,0,1,1,0},//3
  {1,0,0,1,1,0,0},//4
  {0,1,0,0,1,0,0},//5
  {0,1,0,0,0,0,0},//6
  {0,0,0,1,1,1,1},//7
  {0,0,0,0,0,0,0},//8
  {0,0,0,0,1,0,0}//9
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
  //pinMode(9,OUTPUT);//DP
  //digitalWrite(9,HIGH);//DP 1 >> off
}
int x = 0;
void loop() {
  Serial.println("loop()...");
  
  int pin = 2;
  for(int i=0;i<7;i++){
    digitalWrite(pin+i,digital[x][i]);
  }
  x++;
  if(x==10)x=0;
  delay(300);
  
}
