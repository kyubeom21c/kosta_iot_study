#include <stdio.h>
void test();
void test2();
int main(int argc, char **argv)
{
	printf("pointer...\n");
	
	int x = 11;
	//10>>%d, 16>>%x, 8>>%o, char>>%c,char[]>>%s
	//double>>%lf,float>>%f,memory address>>%p
	printf("x...%d,%x,%o\n",x,x,x);
	printf("&x...%p\n",&x);
	
	int y = x;
	printf("y...%d\n",y);
	printf("&y...%p\n",&y);
	
	//int *pt = 0;
	int *pt = NULL;
	printf("pt...%p\n",pt);
	
	int *ptx = NULL;
	ptx = &x;
	printf("ptx...%p\n",ptx);
	printf("ptx sizeof...%d byte\n",sizeof(ptx));
	printf("*ptx...%d\n",*ptx);
	
	int *pta = 0;
	printf("pta...%p\n",pta);
	//printf("*pta...%d\n",*pta);//error
	
	
	test(&x);
	
	test2(&y);
	
	return 0;
}
void test2(int *pty){
	printf("test2()...%p, %d\n", pty, *pty);
}
void test(int *ptx){
	printf("test()...%p, %d\n", ptx , *ptx);
}

