#include <stdio.h>

int main(int argc, char **argv)
{
	printf("pointer 3 pointer ..\n");
	
	int x = 10;
	printf("x %d\n",x);
	
	int  *pt = &x;
	printf("pt %p\n",pt);
	printf("*pt %d\n",*pt);
	
	*pt = 50;
	printf("*pt %d\n",*pt);
	printf("x %d\n",x);
	
	int **ppt = &pt;
	printf("ppt %p\n",ppt);
	
	**ppt = 100;
	printf("x %d\n",x);
	
	int ***pppt=&ppt;
	***pppt = 333;
	printf("x %d\n",x);
	printf("***pppt %d\n",***pppt);
	
	return 0;
}



