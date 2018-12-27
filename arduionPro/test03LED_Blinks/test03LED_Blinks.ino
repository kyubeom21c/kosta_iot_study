#define LED2 2
#define LED3 3
#define LED4 4
#define LED5 5
#define LED6 6
#define TIME 50
void setup() {
  pinMode(LED2, OUTPUT); pinMode(LED3, OUTPUT);pinMode(LED4, OUTPUT);pinMode(LED5, OUTPUT);pinMode(LED6, OUTPUT);
}
void loop() {
  digitalWrite(LED2, HIGH);   
  delay(TIME);                       
  digitalWrite(LED2, LOW);   
  digitalWrite(LED3, HIGH);
  delay(TIME);    
  digitalWrite(LED3, LOW);   
  digitalWrite(LED4, HIGH);
  delay(TIME); 
  digitalWrite(LED4, LOW);   
  digitalWrite(LED5, HIGH);
  delay(TIME);  
  digitalWrite(LED5, LOW);   
  digitalWrite(LED6, HIGH);
  delay(TIME);  
  digitalWrite(LED6, LOW);                   
}
