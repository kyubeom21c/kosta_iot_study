#include <stdio.h>

int main(int argc, char **argv)
{
	printf("hello type\n");
	
	int su = 100;  //2~4byte
	printf("su: %d\n",su);
	
	unsigned int su2 = -200;
	printf("unsigned su2: %u\n",su2);
	
	char c = 'a';//1byte
	printf("char: %c\n",c);
	
	unsigned char c2 = 'a';//1byte
	printf("unsigned char: %u\n",c2);
	
	short s1 = 32768;//2byte
	printf("short: %d\n",s1);
	
	unsigned short s2 = 32768;//2byte
	printf("unsigned short: %u\n",s2);
	
	long lng1 = 2200000000;//4byte
	printf("long: %ld\n",lng1);
	
	unsigned long lng2 = 2200000000;//4byte
	printf("unsigned long: %lu\n",lng2);
	
	float f = 3.141592f;
	printf("float: %f\n",f);
	printf("float: %.3f\n",f);
	
	double d = 3.141592;
	printf("double: %lf\n",d);
	printf("double: %.3lf\n",d);
	
	return 0;
}

