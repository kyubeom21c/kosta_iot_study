#include <stdio.h>

int main(int argc, char **argv)
{
	printf("if else for goto\n");
	
	int x,i;
	for(x=0;x<10;x++){
		printf("%d:",x);
		for(i=0;i<10;i++){
			//if(x==5) break;
			//if(i==5) continue;
			if(i==5) goto EXIT;
			printf("%d",i);
			
		}
		printf("\n");
	}
	printf("\n");
	
	EXIT : printf("EXIT....\n");
	
	return 0;
}

