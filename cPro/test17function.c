#include <stdio.h>
void test();
int  test2();
char* test3();
int main(int argc, char **argv)
{
	printf("function...\n");
	
	
	int x = 100;
	int y = 200;
	char z[] = "yangssem";
	test(x,y,z);
	
	
	printf("function.test2()..%d\n",test2());
	printf("function.test3()..%s\n",test3());
	
	return 0;
}
char* test3(){
	//char name[] = "kim";//error
	char *name = "kim";
	return name;
}

void test(int x,int y,char z[]){
	printf("test()..%d...%d...%s\n",x,y,z);
	
}
int test2(){
	printf("test2().\n");
	return 111;
}
