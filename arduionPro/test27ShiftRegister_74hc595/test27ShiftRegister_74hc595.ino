//시프트 레지스터로 8개의 LED 순차 깜빡


int st_cp = 2;//STorage register Clock Pin
int sh_cp = 3;//SHift register Clock Pin
 
// Q0~Q7 까지의 모든 데이터 핀 통제
int ds = 4;// Date Serial input
 
void setup() {
  pinMode(st_cp, OUTPUT);
  pinMode(sh_cp, OUTPUT);
  pinMode(ds, OUTPUT);
}

void loop() {
  for (int i = 0 ; i < 8 ; i++) {
    digitalWrite(st_cp, LOW);
   
    shiftOut(ds, sh_cp, MSBFIRST, 1 << i);//좌에서 우 효과
    //shiftOut(ds, sh_cp, LSBFIRST, 1 << i);//우에서 좌 효과
    
    digitalWrite(st_cp, HIGH);
    delay(100);
  }
}
