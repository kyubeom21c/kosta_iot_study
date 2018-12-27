#include <stdio.h>

int main(int argc, char **argv)
{
	printf("switch...\n");
	int x = 9;
	
	switch(x){
		case 10 :
			printf("x: %d\n",x);
			goto EXIT;
		case 9 :
			printf("x: %d\n",x);
			break;	
		default : 
			printf("x: %d\n",x);
			break;	
	}
	printf("break...%d\n",__LINE__);
	EXIT : printf("EXIT...%d\n",__LINE__);
	return 0;
}

