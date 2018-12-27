#include <stdio.h>

int main(int argc, char **argv)
{
	printf("scanf....\n");
	
	printf("input your name[200 byte]:\n");
	char name[201];
	scanf("%200s",name);
	printf("name :%s\n",name);
	
	int su;
	printf("input your su:\n");
	scanf("%d",&su);
	printf("su :%d\n",su);
	
	int age;
	printf("input your age:\n");
	scanf("%d",&age);
	printf("age :%p\n",&age);
	printf("age :%d\n",age);
	
	double avg;//99.99
	printf("input your avg:\n");
	scanf("%lf",&avg);
	printf("avg :%p\n",&avg);
	printf("avg :%lf\n",avg);
	
	
	//0x7ea18e18 
	//0x >> 16진 수
	//00000000~ffffffff >> 32bit메모 리
	//00000000 00000000~ffffffff ffffffff >>62bit
	
	
	return 0;
}

