#include <stdio.h>
struct list{
	int num;
	struct list *next;
};
int main(int argc, char **argv)
{
	printf("hello struct Linked List\n");
	
	struct list a={10}, b={20}, c={30}, d={40};
	printf("&a %p\n",&a);
	printf("&b %p\n",&b);
	printf("&c %p\n",&c);
	printf("&d %p\n",&d);
	
	
	printf("a.num %d\n",a.num);
	printf("b.num %d\n",b.num);
	printf("c.num %d\n",c.num);
	printf("d.num %d\n",d.num);
	
	a.next = &b;
	b.next = &c;
	c.next = &d;
	//d.next = &a;
	
	printf("a.next %p\n",a.next);
	printf("b.next %p\n",b.next);
	
	printf("a.num %d\n",a.num);
	printf("a.next->num : %d\n",a.next->num);
	printf("a.next->next->num : %d\n",a.next->next->num);
	printf("a.next->next->next->num : %d\n",a.next->next->next->num);
	//printf("a.next->next->next->next->num : %d\n",a.next->next->next->next->num);
	
	////////////////////////////////
	struct list *pt_head = &a;
	while(pt_head != NULL){
		printf("%d, %p\n",pt_head->num, pt_head);
		pt_head = pt_head->next;
	}
	
	
	
	
	return 0;
}



