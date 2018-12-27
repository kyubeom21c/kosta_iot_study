#include <stdio.h>
#include "test18functionheader.h"

int main(int argc, char **argv)
{
	printf("function.header..\n");
	printf("su:%d\n",su);
	test();
	
	printf("sum:%d\n",sum(100,200));
	printf("su:%d\n",su);
	
	
	return 0;
}

