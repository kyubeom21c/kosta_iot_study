char c;
void setup() {
  Serial.begin(9600);
}
void loop() {
  c=Serial.read();

  switch(c){
  case 'r':
    Serial.write("\n r >> RED \n");break;
  case 'g':
    Serial.write("\n g >> GREEN \n");break;
  case 'b':
    Serial.write("\n b >> BLUE \n");break;
  }
}
