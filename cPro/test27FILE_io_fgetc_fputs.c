#include <stdio.h>
#define nil NULL;
int main(int argc, char **argv)
{
	printf("hello FILE io fgetc fputc\n");
	
	//r(in:read),w(out:write),a(out:append)
	FILE *fp_read = fopen("test27.txt","r");
	FILE *fp_write = fopen("test27write.txt","a");
	
	printf("%p\n",fp_read);
	
	if(fp_read == NULL){
		printf("file not found\n");
		return 1;
	}
	
	char c = fgetc(fp_read);
	while(c != 255){//linux 255,window -1
		printf("%c\n",c);
		fputc(c,fp_write);
		c = fgetc(fp_read);
	}
	
	fclose(fp_read);
	fclose(fp_write);
	
	
	printf("\n");
	
	return 0;
}



