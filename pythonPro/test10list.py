#!/usr/bin/env python
# -*- coding: utf-8 -*-
import sys
print("list")

lst = []
lst = [0,0,0,0]
lst = [1,2,3,4]

lst = [0 for _ in range(10)]#0,0,0,0.....
lst = [1 for _ in range(10)]#1,1,1,1,...
lst = [i for i in range(10)]#0~9
lst = [i+1 for i in range(10)]#1~10
lst = [i**2 for i in range(10)]#n**2

print(type(lst))
print(lst)

for item in lst:
	print(item),

print

for index,item in enumerate(lst):
	print(index,item),

print("\n")
print("lst[-1]",lst[-1])
print("lst[0]",lst[0])
####################

lst = [11,22,33]
lst = lst + [44,55,66]
print(lst)
####################

lst = lst *2
print(lst)
####################

lst.append(11)
lst.append(12)
lst.append(13)
print(lst)
####################

lst.sort()
print(lst)
####################

lst.reverse()
print(lst)
####################

lst = ["x","c","k","x0","x01","x101"]
lst.sort()
print(lst)
####################

lst.insert(0,"aaa")
lst.insert(3,"bbb")
print(lst)
####################

lst.remove("x101")
print(lst)
####################

lst.pop()
lst.pop()
print(lst)
####################

lst[2] = [77,88,99]
print(lst)
####################

lst = [1,2,3,4,5,6]
lst[1:3] = [33,44,55]
print(lst)
####################

del lst[1]
print(lst)
####################
lst[2:4] = []
print(lst)
####################

lst.append([11,22,33])
lst.append([44,55,66])
lst.append(100)
print(lst)
####################

lst.extend([77,88,99])
print(lst)
####################

