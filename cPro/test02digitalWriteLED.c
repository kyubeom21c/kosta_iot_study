#include <stdio.h>
#include <wiringPi.h>
#define LED4 4 //gpio 23
int main(int argc, char **argv)
{
	printf("hello gpio\n");
	
	if(wiringPiSetup() == -1) return 1;
	printf("wiringPiSetup OK...\n");
	
	int mTime = 1000;
	
	pinMode(LED4,OUTPUT);
	
	
	while(1){
		digitalWrite(LED4,1);
		delay(mTime);
	
		digitalWrite(LED4,0);
		delay(mTime);
	
		
	}
	
	
	return 0;
}

