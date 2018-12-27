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
	Contact ctt2 = {"051","bbb@bbb.com","busan"};
	Contact ctt3 = {"031","ccc@bbb.com","bundang"};
	
	Contact cs[3] = {ctt1,ctt2,ctt3};
	
	for(int i=0;i<3;i++){
		printf("%s %s %s\n",cs[i].tel,cs[i].email,cs[i].addr);
	}
	
	Score s1 = {99,88,77,s1.kor+s1.eng+s1.math,
			s1.total/3.0};
	Score s2 = {11,22,33,s2.kor+s2.eng+s2.math,
			s2.total/3.0};
	Score s3 = {44,55,66,s3.kor+s3.eng+s3.math,
			s3.total/3.0};
			
	Score ss[3] = {s1,s2,s3};
	for(int i=0;i<3;i++){
		printf("%d%5d%5d%5d%5.1lf\n",
			ss[i].kor, ss[i].eng, ss[i].math, ss[i].total, ss[i].avg);
	}
	
	printf("\n");
	
	struct student std1 = {"kim",ctt1,s1};
	struct student std2 = {"kim2",ctt2,s2};
	struct student std3 = {"kim3",ctt3,s3};
	
	
	int arr[3] = {88,22,55};
	
	for(int x=0;x<3;x++){
		for(int i=x+1;i<3;i++){
			if(arr[x] > arr[i]){
				int temp;
				temp = arr[x];
				arr[x] = arr[i];
				arr[i] = temp;
			}
		}
	}
	for(int i=0;i<3;i++){
		printf("%d\n",arr[i] );
	}
	
	
	
	
	struct student stds[3] = {std1,std2,std3};
	
	for(int x=0;x<3;x++){
		for(int i=x+1;i<3;i++){
			if(stds[x].s.total > stds[i].s.total){
				struct student temp;
				temp = stds[x];
				stds[x] = stds[i];
				stds[i] = temp;
			}
		}
	}
	
	for(int i=0;i<3;i++){
		printf("%s ",stds[i].name);
		printf("%s %s %s\n",stds[i].ctt.tel,stds[i].ctt.email,stds[i].ctt.addr);
		printf("%d%5d%5d%5d%5.1lf\n",
			stds[i].s.kor, stds[i].s.eng, stds[i].s.math, stds[i].s.total, stds[i].s.avg);
		printf("==========\n");	
	}
	
	return 0;
}

