#!/usr/bin/env python
# -*- coding: utf-8 -*-
import sys

print('sys and if else')

#python test03sys_if.py 11

print("msg:",sys.argv[0])
print("msg:",sys.argv[1])

#raw_input()>>python2.X  , 
#input()>>python3.X
print("input your name:")
#name = raw_input()
name = input()
hi="hello"
print(name)
print(hi)
print(name+" "+hi)
print("{} {}",name,hi)
print("{} {}".format(name,hi))

if True :
	print("{} {}".format(name,hi))

if 5>=5 :
	print("{} {}".format(name,hi))
print("{} {}".format(name,hi))
print("{} {}".format(name,hi))


a= 3.14
print(type(a))
print(float(a))
print(type(float(a)))

if float(a) == 3.14:
	print("lee")
elif a==3:
	print("sam")
elif a==5:
	print("five")
else :
	print("other")
