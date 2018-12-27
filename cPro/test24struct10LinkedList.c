#include <stdio.h>
struct list{
	int num;
	struct list *next;
};
int main(int argc, char **argv)
{
	printf("hello struct Linked List\n");
	
	struct list a={10}, b={20}, c={30};
	printf("&a %p\n",&a);
	printf("&b %p\n",&b);
	printf("&c %p\n",&c);
	
	
	printf("a.num %d\n",a.num);
	printf("b.num %d\n",b.num);
	printf("c.num %d\n",c.num);
	
	a.next = &b;
	b.next = &c;
	c.next = &a;
	
	printf("a.next %p\n",a.next);
	printf("b.next %p\n",b.next);
	
	printf("a.next->num : %d\n",a.next->num);
	printf("a.next->next->num : %d\n",a.next->next->num);
	
	
	
	return 0;
}



