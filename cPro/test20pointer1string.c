#include <stdio.h>
void printStr(char strs[3][10] );
void printStr2(char (*pt_str)[10]);
int main(int argc, char **argv)
{
	printf("pointer.string ..\n");
	
	char str[] = "yangssem";
	printf("str %s\n",str);
	printf("str %p\n",str);
	printf("str[0] %c , %p\n", str[0] , &str[0]);
	printf("str[1] %c , %p\n", str[1] , &str[1]);
	printf("str[2] %c , %p\n", str[2] , &str[2]);
	
	char strs[3][10] = {"kim","lee","yangssem"};
	//printf("strs %s\n",strs);
	printf("strs %p\n",strs);
	printf("strs[0] %p\n",strs[0]);
	printf("strs[0] %s\n",strs[0]);
	printf("strs[1] %s\n",strs[1]);
	printf("strs[2] %s\n",strs[2]);
	for(int i=0;i<3;i++){
		printf("strs[%d] %s, %s\n",i,strs[i],&strs[i][0]);
	}
	
	char *pt_str[3];
	pt_str[0] = &strs[0][0];
	pt_str[1] = &strs[1][0];
	pt_str[2] = &strs[2][0];
	
	for(int i=0;i<3;i++){
		printf("pt_str[%d] %s %c\n",i,pt_str[i],*pt_str[i]);
	}
	
	printStr(strs);
	printStr2(strs);
	
	return 0;
}
void printStr2(char (*pt_str)[10]){
	for(int i=0;i<3;i++){
		printf("pt_str[%d] %s %c\n",i,pt_str[i],*pt_str[i]);
	}
}
void printStr(char strs[3][10] ){
	for(int i=0;i<3;i++){
		printf("strs[%d] %s, %s\n",i,strs[i],&strs[i][0]);
	}
}


