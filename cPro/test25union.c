#include <stdio.h>

struct Test{
	int num;
	double avg;
};

union Score{
	int num;
	double avg;
};

int main(int argc, char **argv)
{
	printf("hello union\n");
	
	struct Test t = {99, 33.33};
	printf("sizeof(t): %d\n",sizeof(t));
	printf("t.num: %d\n",t.num);
	printf("t.avg: %.2lf\n",t.avg);
	
	union Score s ;
	printf("sizeof(s): %d\n",sizeof(s));
	s.num = 99;
	printf("s.num: %d\n",s.num);
	s.avg = 33.33;
	printf("s.avg: %.2lf\n",s.avg);
	
	union Score s2 = {.avg=88.88};
	printf("s2.avg: %.2lf\n",s2.avg);
	
	struct Test t2 = {.avg=3.14};
	printf("t2.avg: %.2lf\n",t2.avg);
	
	return 0;
}



