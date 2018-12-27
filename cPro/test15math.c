#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

int main(int argc, char **argv)
{
	printf("hello math...\n");
	//gcc -Wall -o "%e" "%f" -l wiringPi -lm
	
	int x = 2;
	int y = 8;
	//#include <math.h>
	printf("pow...%.2lf\n",pow(x,y));
	
	int h = 100;
	printf("sqrt...%.2lf\n",sqrt(h));
	
	
	
	//#include <stdlib.h>
	printf("abs...%d\n",abs(-111));
	
	
	printf("ceil -99.99...%f\n",ceil(-99.99));
	printf("ceil 99.99...%f\n",ceil(99.99));
	printf("floor 99.99...%f\n",floor(99.99));
	printf("floor -99.99...%f\n",floor(-99.99));
	
	//#include <time.h>
	//#include <stdlib.h>
	srand(time(NULL));//seed value setup 1970.01.01~
	int i;
	for(i=0;i<10;i++){
		printf("rand %d\n", rand()%10);
	}
	
	
	return 0;
}

