#include <stdio.h>
#define ROW_MAX 2
#define COL_MAX 3
int main(int argc, char **argv)
{
	printf("pointer.array array..\n");
	
	int arr[ROW_MAX][COL_MAX] = {{1,2,3},{4,5,6}};
	printf("arr %p\n",arr);
	
	int (*row)[COL_MAX] ;//&{1,2,3},     &{4,5,6}
	int *col;//&1,&2,&3   &4,&5,&6
	//row+0,row+1>> row++,row++
	for(row=arr;row<arr+ROW_MAX;row++){
		printf("row *row **row: %p,%p,%d\n", row, *row, **row);
		//col+0,col+1,col+2 >> col++,col++,col++
		for(col=*row;col<*row+COL_MAX;col++){
			printf("%d ",*col);
		}
		printf("\n");
	}
	
	
	return 0;
}


