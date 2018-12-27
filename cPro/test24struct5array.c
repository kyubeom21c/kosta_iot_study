#include <stdio.h>
typedef struct contact{
		char *tel,*email,*addr;
} Contact;
typedef struct score{
		int kor;
		int eng;
		int math;
		int total;
		double avg;
} Score;
struct student{
		char *name;
		
		//struct contact ctt;
		Contact ctt;
		//struct score s;
		Score s;
} ;

int main(int argc, char **argv)
{
	printf("hello struct array\n");
	
	Contact ctt1 = {"02","aaa@aaa.com","seoul"};
	Contact ctt2 = {"031","bbb@bbb.com","busan"};
	
	Contact cs[2] = {ctt1,ctt2};
	
	for(int i=0;i<2;i++){
		printf("%s %s %s\n",cs[i].tel,cs[i].email,cs[i].addr);
	}
	
	Score s1 = {99,88,77,s1.kor+s1.eng+s1.math,
			s1.total/3.0};
	Score s2 = {11,22,33,s2.kor+s2.eng+s2.math,
			s2.total/3.0};
			
	Score ss[2] = {s1,s2};
	for(int i=0;i<2;i++){
		printf("%d%5d%5d%5d%5.1lf\n",
			ss[i].kor, ss[i].eng, ss[i].math, ss[i].total, ss[i].avg);
	}
	
	printf("\n");
	
	struct student std1 = {"kim",ctt1,s1};
	struct student std2 = {"kim2",ctt2,s2};
	
	struct student stds[2] = {std1,std2};
	for(int i=0;i<2;i++){
		printf("%s ",stds[i].name);
		printf("%s %s %s\n",stds[i].ctt.tel,stds[i].ctt.email,stds[i].ctt.addr);
		printf("%d%5d%5d%5d%5.1lf\n",
			stds[i].s.kor, stds[i].s.eng, stds[i].s.math, stds[i].s.total, stds[i].s.avg);
		printf("==========\n");	
	}
	
	return 0;
}

