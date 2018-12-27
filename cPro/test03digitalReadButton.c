#include <stdio.h>
#include <wiringPi.h>
#define BUTTON 0 //gpio 17
int main(int argc, char **argv)
{
	printf("hello gpio\n");
	
	if(wiringPiSetup() == -1) return 1;
	printf("wiringPiSetup OK...\n");
	
	int mTime = 1000;
	
	pinMode(BUTTON,INPUT);
	
	
	while(1){
		
		printf("digitalRead %d\n",digitalRead(BUTTON));
		delay(mTime);
	
		
	}
	
	
	return 0;
}

