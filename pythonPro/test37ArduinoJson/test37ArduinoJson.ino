//ArduinoJson.h 라이브러리관리에서 검색후 추가할것.
#include <ArduinoJson.h>
#define LED2 2
#define LED4 4

StaticJsonDocument<200> doc;
void setup() {
  Serial.begin(9600);
  pinMode(LED2,OUTPUT);
  pinMode(LED4,OUTPUT);
}

void loop() {
  //{"led1":"on","led2":"off"}
  //{"led1":"off","led2":"on"}
  //{"led1":"on","led2":"on"}
  //{"led1":"off","led2":"off"}
  if(Serial.available()){
    String json =Serial.readString();
    Serial.println(json);
    deserializeJson(doc, json);
    JsonObject root = doc.as<JsonObject>();
    String led1 = root["led1"];
    String led2 = root["led2"];
    Serial.println(led1);
    Serial.println(led1=="on");
    Serial.println(led2);
    Serial.println(led2=="on");
    if(led1=="on"){
     digitalWrite(LED2,HIGH);
    }
    if(led1=="off"){
      digitalWrite(LED2,LOW);
    }
    
    if(led2=="on"){
      digitalWrite(LED4,HIGH);
    }
    if(led2=="off"){
      digitalWrite(LED4,LOW);
    }
    
  }
  
  
  
}
