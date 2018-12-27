#define TIME 500
void setup() {
  Serial.begin(9600);
  Serial.println("setup()...");  
}

void loop() {
  int i;
  for(i=0;i<10;i++){
    Serial.print(i);
    Serial.print(" ");
    delay(TIME);
  }
  Serial.print("\n");
}
