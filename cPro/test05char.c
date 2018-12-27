#include <stdio.h>
#include <string.h>

int main(int argc, char **argv)
{
	printf("hello char...\n");
	
	//할 당 
	char cs[] = "kim";//'k','i','m',null
	printf("cs: %s\n",cs);
	
	//할 당 
	char cs2[6] = {'h','e','l','l','o'};//"hello"
	printf("cs2: %s\n",cs2);
	printf("cs2.length: %d\n",strlen(cs2));
	
	//비 교
	printf("strcmp(cs,cs2): %d\n",strcmp(cs,cs2));
	printf("strcmp(cs2,cs): %d\n",strcmp(cs2,cs));
	
	//char search
	printf("strchr(cs2,'u'): %s\n",strchr(cs2,'u'));
	
	//copy
	char name1[10] = "yangssem";
	char name2[10];
	strcpy(name2,name1);
	printf("name2: %s\n",name2);
	
	//병 합 
	strcat(name2, " is My name");
	printf("name2: %s\n",name2);
	
	// 토큰자르기
	printf("name2: %s\n",strtok(name2," "));
	
	char txt[10] = "abcabc";
	printf("strstr: %s\n",strstr(txt,"b"));
	printf("strstr: %s\n",strstr(txt,"z"));
	
	char *x = "aaa";
	printf("x: %s\n",x);
	return 0;
}

