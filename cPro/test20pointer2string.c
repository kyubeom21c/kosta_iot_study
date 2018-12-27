#include <stdio.h>

int main(int argc, char **argv)
{
	printf("pointer2string ..\n");
	
	
	char *pt_str[3] = {"kim","lee","yangssem"};
	for(int i=0;i<3;i++){
		printf("%s\n",pt_str[i]);
	}
	
	char name[4] = "kim";
	char strs[3][10] = {name,"lee","yangssem"};
	for(int i=0;i<3;i++){
		printf("%s, %s\n",strs[i],&strs[i][0]);
	}
	
	return 0;
}



