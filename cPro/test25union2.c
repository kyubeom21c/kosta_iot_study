#include <stdio.h>

typedef union names{
	char a_name[10];//8*2
	char b_name[12];//8*2
	char c_name[14];//8*2
	char c_name2[16];//8*2
	char c_name3[18];//8*3
	double d_name;//8byte
} U_names;

int main(int argc, char **argv)
{
	printf("hello union2\n");
	
	U_names un;
	printf("sizeof(un): %d\n",sizeof(un));
	
	return 0;
}



