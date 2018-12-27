#include <stdio.h>
const int a = 10;
const int b = 20;
const int c = 30;
enum Car{
	Ray,Sonata,Snatafe,Volvo,OOOO,BMW
};
int main(int argc, char **argv)
{
	printf("hello enum\n");
	
	printf("Ray : %d\n",Ray);
	printf("Sonata : %d\n",Sonata);
	printf("Snatafe : %d\n",Snatafe);
	printf("Volvo : %d\n",Volvo);
	printf("OOOO : %d\n",OOOO);
	printf("BMW : %d\n",BMW);
	
	enum Car c;
	printf("sizeof(c) : %d\n",sizeof(c));
	c = OOOO;
	switch(c){
		case Ray : 
			printf("Your Car code : %d\n",c);
			break;
		case Sonata : 
			printf("Your Car code : %d\n",c);
			break;
		case Snatafe : 
			printf("Your Car code : %d\n",c);
			break;
		case Volvo : 
			printf("Your Car code : %d\n",c);
			break;
		case OOOO : 
			printf("Your Car code : %d\n",c);
			break;
		case BMW : 
			printf("Your Car code : %d\n",c);
			break;
		default:
			printf("other\n");
			break;
	}
	
	return 0;
}



