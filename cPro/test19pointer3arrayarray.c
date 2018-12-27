#include <stdio.h>
#define ROW_MAX 2
#define COL_MAX 3
int main(int argc, char **argv)
{
	printf("pointer.array array..\n");
	
	int arr[ROW_MAX][COL_MAX] = {{1,2,3},{4,5,6}};
	printf("arr %p\n",arr);
	
	int (*pt)[COL_MAX] = arr;//&{1,2,3},&{4,5,6}
	printf("pt  %p\n",pt);
	//pt[0] == arr[0]
	//pt[0][0] == arr[0][0]
	
	int x,i;
	for(x=0;x<ROW_MAX;x++){
		for(i=0;i<COL_MAX;i++){
			printf("%d ",pt[x][i]);
		}
		printf("\n");
	}
	
	
	
	return 0;
}


