#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
	printf("hello malloc  calloc  readloc free\n");
	
	int arr[10];
	int *pt_arr;
	
	pt_arr = arr;
	for(int i=0;i<10;i++){
		arr[i] = i+1;
	}
	
	//pt_arr = (int*)malloc(sizeof(int)*10);
	//java >>> int arr[] = {0,0,0,0,0,0,0,0,0,0};
	
	pt_arr = (int*)calloc(10,sizeof(int));
	//java >>> int arr[] = new int[10];
	for(int i=0;i<10;i++){
		pt_arr[i] = arr[i];
	}
	
	//update set
	pt_arr = realloc(pt_arr,sizeof(int)*5);
	
	free(pt_arr);//remove
	
	for(int i=0;i<10;i++){
		printf("%d ", pt_arr[i]);
	}
	printf("\n");
	
	return 0;
}

