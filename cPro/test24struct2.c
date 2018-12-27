#include <stdio.h>
#include <time.h>
struct Student{
	char *pt_name;
	int kor;
	int eng;
	int math;
	int total;
	double avg;
};

typedef struct Member{
	int num;
	char *id;
	char *pw;
	char *name;
	char *tel;
	time_t time;
} MEM;

int main(int argc, char **argv)
{
	printf("hello struct2\n");
	
	//struct Student st;
	typedef struct Student STD;
	STD st;
	st.pt_name = "kim";
	st.kor = 20;
	st.eng = 30;
	st.math = 40;
	st.total = st.kor + st.eng +st.math;
	st.avg = st.total/3.0;
	printf("name: %s\n",st.pt_name);
	printf("kor: %d\n",st.kor);
	printf("eng: %d\n",st.eng);
	printf("math: %d\n",st.math);
	printf("total: %d\n",st.total);
	printf("avg: %.1lf\n",st.avg);
	printf("=================\n");
	
	//STD st2;
	struct Student st2 = {
			"yangssem",99,88,77,st2.kor+st2.eng+st2.math,
			st2.total/3.0
	};
	
	printf("name: %s\n",st2.pt_name);
	printf("kor: %d\n",st2.kor);
	printf("eng: %d\n",st2.eng);
	printf("math: %d\n",st2.math);
	printf("total: %d\n",st2.total);
	printf("avg: %.1lf\n",st2.avg);
	printf("=================\n");
	
	MEM m1,m2,m3;
	m1.num = 88;
	m2.num = 99;
	m3.num = 77;
	printf("m1.num: %d\n",m1.num);
	printf("m2.num: %d\n",m2.num);
	printf("m3.num: %d\n",m3.num);
	
	struct tm *pt_time;
	time(&m1.time);
	pt_time = localtime(&m1.time);
	printf("%ld\n",m1.time);
	printf("%p\n",pt_time);
	printf("%s\n",asctime(pt_time));
	
	return 0;
}

