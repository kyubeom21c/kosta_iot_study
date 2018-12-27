#include <stdio.h>
typedef struct member{
	int num;
	char *id;
	char *pw;
	char *name;
	char *tel;
} Member;

void test(Member m);
void test2(Member *pt_m);


int main(int argc, char **argv)
{
	printf("hello struct pointer\n");
	
	Member m;
	
	m.num = 1;
	m.id = "admin";
	m.pw = "hi123456";
	m.name = "kim";
	m.tel = "010";
	
	printf("%d %s %s %s %s\n",m.num,m.id,m.pw,m.name,m.tel);
	printf("sizeof(m): %d byte\n",sizeof(m));
	
	Member *pt_m;
	pt_m = &m;
	printf("sizeof(pt_m): %d byte\n",sizeof(pt_m));
	(*pt_m).num = 9;
	(*pt_m).id = "admin9";
	(*pt_m).pw = "hi9999";
	(*pt_m).name = "kim9";
	(*pt_m).tel = "099";
	printf("%d %s %s %s %s\n",(*pt_m).num,(*pt_m).id,(*pt_m).pw,(*pt_m).name,(*pt_m).tel);
	
	pt_m -> num = 3;
	pt_m -> id = "admin3";
	pt_m -> pw = "hi3333";
	pt_m -> name = "kim3";
	pt_m -> tel = "033";
	printf("%d %s %s %s %s\n",pt_m->num,pt_m->id,pt_m->pw,pt_m->name,pt_m->tel);
	
	printf("+++++++++\n");
	test(m);
	printf("+++++++++\n");
	test2(&m);
	printf("+++++++++\n");
	
	return 0;
}

void test(Member m){
		printf("%d %s %s %s %s\n",m.num,m.id,m.pw,m.name,m.tel);
		printf("sizeof(m): %d byte\n",sizeof(m));
}
void test2(Member *pt_m){
		printf("%d %s %s %s %s\n",(*pt_m).num,(*pt_m).id,(*pt_m).pw,(*pt_m).name,(*pt_m).tel);
		printf("%d %s %s %s %s\n",pt_m->num,pt_m->id,pt_m->pw,pt_m->name,pt_m->tel);
		printf("sizeof(pt_m): %d byte\n",sizeof(pt_m));

}

