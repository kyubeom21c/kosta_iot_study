#include <stdio.h>
#include <stdlib.h>
struct score{
	char *name;
	int kor;
	int eng;
};
int main(int argc, char **argv)
{
	printf("hello struct scanf\n");
	
	struct score s;
	struct score *pt_s;
	pt_s = &s;
	
	//#include <stdlib.h>
	s.name = (char*)malloc(20);
	
	printf("input your name:");
	scanf("%s",pt_s->name);
	printf("%s\n",pt_s->name);
	
	printf("input kor:");
	scanf("%d",&pt_s->kor);
	printf("%d\n",pt_s->kor);
	
	free(s.name);
	return 0;
}



