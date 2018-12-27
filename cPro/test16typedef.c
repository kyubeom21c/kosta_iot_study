#include <stdio.h>

int main(int argc, char **argv)
{
	printf("typedef...\n");
	
	typedef int INT;
	
	INT x = 10;
	printf("typedef...%d\n",x);
	
	typedef unsigned int Uint;
	Uint y = -999;
	printf("unsigned...%u\n",y);
	
	return 0;
}

