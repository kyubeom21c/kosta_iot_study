#include <stdio.h>

int main(int argc, char **argv)
{
	printf("pointer.array ..\n");
	
	int sus[3] = {1,2,3};
	//sus == &sus[0]
	//*sus == sus[0]
	//*(sus+0) == sus[0]
	//pt+1 == pt + sizeof(*pt)
	//pt[x] == arr[x]
	//pt[x][i] == arr[x][i]
	//(*pt)[col_max] == arrayarray
	// arrayarray >> row >> arr[0] >> arr[0][0]
	
	int a=10,b=20,c=30,d=40;
	printf("%d %d %d %d\n",a,b,c,d);
	int *ptr[4];
	ptr[0] = &a;
	ptr[1] = &b;
	ptr[2] = &c;
	ptr[3] = &d;
	printf("%d %d %d %d\n",*ptr[0] ,*ptr[1] ,*ptr[2] ,*ptr[3] );
	
	return 0;
}


