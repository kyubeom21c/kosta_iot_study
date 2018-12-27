#!/usr/bin/env python
# -*- coding: utf-8 -*-
import sys

print('for')

#0~9
for i in range(10):
	print(i),
#python2.x >>> ,(comma)사용 시 가로출력가 능

print

#10~19
for i in range(10,20):
	print(i),
	
#python3.x >>> i,end=' ' 사용 시 가로출력가 능	
#for i in range(10,20):
#	print(i,end=',')
#	print(i,end=' ')
print	
for i in range(10,20):
	print("{}*{}={}".format(i,10,i*10)),	
print
#9*9 dan
for x in range(2,10):
	for i in range(1,10):
		print("{}*{}={}".format(x,i,x*i)),
	print

#list >> java,c,js : array
lst = [11,22,33,44,55]
print("lst",type(lst))
print("len(lst):",len(lst))

for i in range(len(lst)):
	print(lst[i])

print("========")

sum=0
for item in lst:
	print(item)
	sum+=item
print("sum:",sum)




