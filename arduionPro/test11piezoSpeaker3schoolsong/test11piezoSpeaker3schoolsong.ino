#include <stdio.h>
#include "pitches.h"
#define BUTTON2 2
#define SPEAKER 8
int melody[] = {
  NOTE_G4, NOTE_G4,//솔,솔
  NOTE_A5, NOTE_A5,//라,라
  NOTE_G4, NOTE_G4,//솔,솔
  NOTE_E4, //미
  NOTE_G4, NOTE_G4,//솔,솔
  NOTE_E4, NOTE_E4,//미,미
  NOTE_D4,//레
  0
};
int noteDurations[] = {
  4,4,
  4,4,
  4,4,
  2,
  4,4,
  4,4,
  1
};
void setup() {
  Serial.begin(19200);
  Serial.print("setup()....");
  pinMode(BUTTON2,INPUT);
}
void loop() { 
  Serial.write("loop()..\n");
  if(digitalRead(BUTTON2)){
    for(int thisNote = 0; thisNote<13;thisNote++){
      int noteDuration = 1000/noteDurations[thisNote];
      tone(SPEAKER,melody[thisNote],noteDuration);
      int pauseBetweenNotes = noteDuration * 1.30;
      delay(pauseBetweenNotes);
      noTone(SPEAKER);
    }
  }
}
