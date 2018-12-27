#include <stdio.h>

int su = 0;
static int su2 = 44;
const int su3 = 88;
int main(int argc, char **argv)
{
	//su3 = 88;//readonly error
	printf("variable...\n");
	su = 11;
	printf("su: %d\n",su);
	
	printf("su2: %d\n",su2);
	
	static int num = 99;
	printf("num: %d\n",num);
	
	if(1){
		auto int su = 333;//auto remove ok
		printf("local su: %d\n",su);
	}
	printf("local su: %d\n",su);
	
	register int total = 100;//CPU speed up
	printf("register total: %d\n",total);
	
	volatile int total2 = 1000;//memory speed up
	printf("register total2: %d\n",total2);
	
	
	
	return 0;
}

