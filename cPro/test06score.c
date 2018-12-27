#include <stdio.h>

int main(int argc, char **argv)
{
	printf("score....\n");
	//int i;
	for(int i=0;i<2;i++){
		printf("input your name[200 byte]:\n");
		char name[11];
		scanf("%10s",name);
		printf("name :%s\n",name);
		
		int kor;
		printf("input kor:\n");
		scanf("%d",&kor);
		printf("kor :%d\n",kor);
		
		int eng;
		printf("input eng:\n");
		scanf("%d",&eng);
		printf("eng :%d\n",eng);
		
		int math;
		printf("input math:\n");
		scanf("%d",&math);
		printf("math :%d\n",math);
		
		int total = kor + eng + math;
		printf("total: %d\n",total);
		
		double avg = total/3.0;
		printf("total: %.2lf\n",avg);
	}
	
	
	
	return 0;
}

