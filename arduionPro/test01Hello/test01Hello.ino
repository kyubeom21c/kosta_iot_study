#include <stdio.h>
#define TIME 500

char msg[] = "loop()...";
char *name = "kim";
void setup() {
  Serial.begin(9600);
  Serial.println("setup()...");  
  
}
void loop() {
  //char msg[] = "loop()...";
  Serial.print(msg); 
  Serial.print(name); 
  Serial.print("yangssem");     
  Serial.print("\t");             
  Serial.print("arduino");  
  Serial.print("\t");      
  Serial.print("Hello"); 
  Serial.print("\n"); 
  delay(TIME);
}
