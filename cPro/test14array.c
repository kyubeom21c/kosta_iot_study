#include <stdio.h>
#include <string.h>

int main(int argc, char **argv)
{
	printf("array...\n");
	
	int sus[] = {1,2,3,4,5};
	printf("sus[0] %d\n",sus[0]);
	printf("sus[1] %d\n",sus[1]);
	printf("sus[2] %d\n",sus[2]);
	printf("sus[3] %d\n",sus[3]);
	printf("sus[4] %d\n",sus[4]);
	printf("sus length: %d\n",sizeof(sus)/sizeof(int));
	for(int i=0;i<sizeof(sus)/sizeof(int);i++){
		printf("sus[%d] %d\n",i,sus[i]);
	}
	
	//mission
	int suss[2][3] = {{1,2,3},{4,5,6}};
	printf("suss : %d byte\n",sizeof(suss));
	printf("suss[0] : %d byte\n",sizeof(suss[0]));
	printf("suss len : %d\n",sizeof(suss)/sizeof(suss[0]));
	
	int x;
	for(x=0;x<sizeof(suss)/sizeof(suss[0]);x++){
		for(int i=0;i<sizeof(suss[x])/sizeof(int);i++){
			printf("suss[%d][%d] %d\n",x,i,suss[x][i]);
		}
	}
	
	char name[10] = "yangssem1";
	printf("%s\n",name);
	
	char names[3][10] = {"yangssem1","yangssem2","yangssem3"};
	printf("%s\n",names[0]);
	printf("sizeof names : %d byte\n",sizeof(names));
	printf("sizeof names[0] : %d byte\n",sizeof(names[0]));
	int namesLen = sizeof(names)/sizeof(names[0]);
	printf("names len : %d\n",namesLen);
	printf("strcmp : %d\n",strcmp(names[0],"yangssem1")==0);
	for(int i=0;i<namesLen;i++){
		printf("names[%d] : %s\n",i,names[i]);
	}
	
	
	return 0;
}

