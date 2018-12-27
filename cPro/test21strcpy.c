#include <stdio.h>
#include <string.h>

int main(int argc, char **argv)
{
	printf("hello strcpy\n");
	
	char str[10] = "KIM";
	printf("%p\n", str);
	printf("%s\n", str);
	printf("%d\n", (int )str);
	
	strcpy(str,"yangssem");
	printf("%p\n", str);
	printf("%s\n", str);
	printf("%d\n", (int )str);
	
	
	return 0;
}

