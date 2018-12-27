#include <stdio.h>
typedef struct test{
		char a;
		char b;
		char c;
		int su1;
		int su2;
		int su3;
		int su4;
		char d;
} Test;

typedef struct bit_test{
		char a:1;
		char b:1;
		char c:1;
		unsigned int su1:2;
		unsigned int su2:3;
		unsigned int su3:7;
		int su4:3;
		char d:2;
} Bit_Test;
int main(int argc, char **argv)
{
	printf("hello struct bit field\n");
	
	printf("sizeof(Test) : %d byte\n",sizeof(Test));
	printf("sizeof(Bit_Test) : %d byte\n",sizeof(Bit_Test));
	
	Bit_Test bt;
	bt.su1 = 1;
	bt.su2 = 7;//111
	bt.su3 = 127;//111 1111
	printf("%u\n",bt.su1);
	printf("%u\n",bt.su2);
	printf("%u\n",bt.su3);
	return 0;
}



