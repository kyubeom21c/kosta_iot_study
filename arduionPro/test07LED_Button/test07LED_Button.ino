#define LED 2
#define BUTTON 7
void setup() {
  pinMode(LED, OUTPUT);
  pinMode(BUTTON, INPUT);
  Serial.begin(9600);
}
void loop() {
  if(digitalRead(BUTTON)==HIGH){
    Serial.println("ON");
    digitalWrite(LED, HIGH);   
  }else{
    Serial.println("OFF");
    digitalWrite(LED, LOW);   
  }
  delay(100); 
  //mission1  >>>  red,green,blue button and LED red,green,blue
  //mission2  >>>  red,green,blue button and RGB_LED red++,green++,blue++

  
                       
}
