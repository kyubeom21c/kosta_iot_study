#include <stdio.h>

int main(int argc, char **argv)
{
	printf("pointer.array ..\n");
	
	//sus == &sus[0]
	//*sus == sus[0]
	//*(sus+0) == sus[0]
	//pt+1 == pt + sizeof(*pt)
	//pt[x] == arr[x]
	//pt[x][i] == arr[x][i]
	//(*pt)[col_max] == arrayarray
	// arrayarray >> row >> arr[0] >> arr[0][0]
	
	int arr[4] = {10,20,30,40};
	
	int *ptr[4];//ptr[0] = &arr[0]
	int i;
	for(i=0;i<4;i++){
		ptr[i] = &arr[i];
	}
	
	for(i=0;i<4;i++){
		printf("%d\n",*ptr[i] );
	}
	
	
	
	return 0;
}


