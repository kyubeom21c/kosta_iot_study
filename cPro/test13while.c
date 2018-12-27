#include <stdio.h>

int main(int argc, char **argv)
{
	printf("while...\n");
	int x = 0;
	while(x<10){
		printf("while...%d\n",x);
		if(x != 0 && x %4 ==0){
			break;
		}else if(x > 5){
			break;
		}
		x++;
	}
	
	return 0;
}

