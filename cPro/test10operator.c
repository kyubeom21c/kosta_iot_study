#include <stdio.h>
#include <stdbool.h>

int main(int argc, char **argv)
{
	printf("operator...\n");
	
	//1. (),  [] ,  ,  , . ->
	printf("int sizeof : %d byte\n", sizeof(int));
	int arr[] = {1,2,3,4,5};
	printf("arr sizeof : %d byte\n", sizeof(arr));
	
	
	//2. (cast), *(pointer)  ++ -- +
	
	//3. * / + - %
	printf("arr length : %d\n", sizeof(arr)/sizeof(int));
	
	//4. <<, >>
	
	//5. == !=, >, <, >=,<=
	printf("5==5 %d\n", 5==5);
	
	//6. & | ^
	
	//7. && ||
	
	//bool type
	//#include <stdbool.h>
	bool b = true;
	printf("bool %d\n", b);
	
	
	
	return 0;
}

