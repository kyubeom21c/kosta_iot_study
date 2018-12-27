#include <stdio.h>
#include <string.h>
#include <wiringPi.h>
#define LED_RED 4 //gpio 23
#define LED_GREEN 0 //gpio 17
#define LED_BLUE 3 //gpio 22 


int main(int argc, char **argv)
{
	printf("array...\n");
	
	char colors[3][6] = {"red","green","blue"};
	int colorsLen = sizeof(colors)/sizeof(colors[0]);
	
	if(wiringPiSetup() == -1) return 1;
	printf("wiringPiSetup OK...\n");
	
	int mTime = 1000;
	
	pinMode(LED_RED,OUTPUT);
	pinMode(LED_GREEN,OUTPUT);
	pinMode(LED_BLUE,OUTPUT);
	
	while(1){
		for(int i=0;i<colorsLen;i++){
			printf("colors[%d] : %s\n",i,colors[i]);
			if(strcmp(colors[i],"red")==0){
				printf("LED_RED ON...\n");
				digitalWrite(LED_RED,1);
				digitalWrite(LED_GREEN,0);
				digitalWrite(LED_BLUE,0);
			}else if(strcmp(colors[i],"green")==0){
				printf("LED_GREEN ON...\n");
				digitalWrite(LED_RED,0);
				digitalWrite(LED_GREEN,1);
				digitalWrite(LED_BLUE,0);
			}else if(strcmp(colors[i],"blue")==0){
				printf("LED_BLUE ON...\n");
				digitalWrite(LED_RED,0);
				digitalWrite(LED_GREEN,0);
				digitalWrite(LED_BLUE,1);
			}
			delay(mTime);
		}
		
	}
	
		
	
	
	return 0;
}

