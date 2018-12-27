#include <stdio.h>
#define nil NULL;
int main(int argc, char **argv)
{
	printf("hello FILE io fgetc\n");
	
	//r(in:read),w(out:write),a(out:append)
	FILE *fp_read = fopen("test27.txt","r");
	
	printf("%p\n",fp_read);
	
	if(fp_read == NULL){
		return 1;
	}
	
	char c = fgetc(fp_read);
	printf("%c(%d)",c,c);
	//c = fgetc(fp_read);
	//printf("%c(%d)",c,c);
	//c = fgetc(fp_read);
	//printf("%c(%d)",c,c);
	while(c != 255){//linux 255,window -1
		//printf("%c\n",c);
		c = fgetc(fp_read);
		printf("%c(%d)",c,c);
	}
	
	fclose(fp_read);
	
	
	printf("\n");
	
	return 0;
}



