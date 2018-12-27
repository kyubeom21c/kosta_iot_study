#include <stdio.h>
#include <stdlib.h>
void test(int *pt);
void test2(int **ppt);
int main(int argc, char **argv)
{
	printf("pointer 4 pointer ..\n");
	int arrs[2][3] = {{1,2,3},{4,5,6}};
	
	int (*row)[3] = arrs;
	printf("row %p\n",row);
	
	int *pt = (int *)arrs;
	printf("pt %p\n",pt);
	test((int *)arrs);
	
	int **ppt = (int **)arrs;
	printf("ppt %p\n",ppt);
	test2((int **)arrs);
	
	return 0;
}

void test(int *pt){
		printf("test()..pt %p\n",pt);
		printf("test()..*(pt+0) %d\n",*(pt+0));
		for(int i=0;i<6;i++){
			printf("test()..*(pt+%d) %d\n",i,*(pt+i));
		}
}
void test2(int **ppt){
	int arrs[2][3] = {{1,2,3},{4,5,6}};
	
	int (*row)[3] = arrs;
	for(int i=0;i<3;i++){
		printf("row[%d] %d %d\n",i,row[i],*row[i]);
	}
}



