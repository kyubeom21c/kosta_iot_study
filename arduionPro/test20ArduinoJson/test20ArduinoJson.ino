//ArduinoJson.h 라이브러리관리에서 검색후 추가할것.
#include <ArduinoJson.h>
StaticJsonDocument<200> doc;
void setup() {
  Serial.begin(9600);
}

void loop() {
  //{"led1":"on","led2":"off"}
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
  }
 
}
