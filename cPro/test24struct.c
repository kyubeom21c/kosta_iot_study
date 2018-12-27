#include <stdio.h>
#include <string.h>
struct Test{
	int x;
	double d;
	char name[10];
	char *pt_name;
};

struct Test2{
	int x;
	double d;
};

int main(int argc, char **argv)
{
	printf("hello struct\n");
	
	struct Test t;
	t.x = 100;
	t.d = 3.14;
	//t.name = "yangssem";//compile error
	strcpy(t.name, "yangssem");
	
	//strcpy(t.pt_name, "yangssem2");//segmentation error
	t.pt_name = "yangssem2";
	
	
	printf("t.x: %d\n",t.x);
	printf("t.d: %.2lf\n",t.d);
	printf("t.name: %s\n",t.name);
	printf("t.pt_name: %s\n",t.pt_name);
	printf("t: %d byte\n",sizeof(t));
	printf("======================\n");
	
	struct Test2 t2;
	t2.x = 33;
	t2.d = 33.14;
	
	printf("t2.x: %d\n",t2.x);
	printf("t2.d: %.2lf\n",t2.d);
	
	return 0;
}

