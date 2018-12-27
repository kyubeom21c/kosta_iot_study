#include <stdio.h>
#define nil NULL;
int main(int argc, char **argv)
{
	printf("hello FILE io feof fscanf fprintf\n");
	
	//r(in:read),w(out:write),a(out:append)
	FILE *fp_read = fopen("test27su.txt","r");
	FILE *fp_write = fopen("test27sum.txt","a");
	
	printf("%p\n",fp_read);
	
	if(fp_read == NULL){
		printf("file not found\n");
		return 1;
	}
	
	int su1,su2;
	while(feof(fp_read)==0){
		fscanf(fp_read,"%d %d",&su1,&su2);
		printf("%d + %d = %d\n",su1,su2,su1+su2);
		fprintf(fp_write,"%d + %d = %d\n",su1,su2,su1+su2);
		printf("feof(fp_read): %d\n",feof(fp_read));
	}
	
	fclose(fp_read);
	fclose(fp_write);
	
	
	printf("\n");
	
	return 0;
}



