#!/usr/bin/env python
# -*- coding: utf-8 -*-

print("inner def")

print(abs(-11))
print(abs(11))


print(all([]))
print(all([1,2,3]))
print(all([1,2,3,0]))
print(all(['aaa','bbb','ccc']))
print(all(['aaa','bbb','ccc','']))
print(all(['aaa','bbb','ccc',""]))

print

print(any([1,2,3,0]))
print(any(['aaa','bbb','ccc',""]))

print
print(dir([]))

print
print(dir(()))

print
print(dir("kim"))

print
print(chr(97),chr(98),chr(66))

print
print(divmod(7,3))
print(type(divmod(7,3)))

print
print(divmod(22.3,12.5))
print(type(divmod(22.3,12.5)))


print
print(eval("'kim'+'lee'"))
print(eval("22+33"))

print
print(hex(10))
print(hex(255))
print(hex(0))

print
print(id("yangssem"))
print(id("a"))


print
class Person:
	pname = "yangssem"

p = Person()
print(p.pname)
print(isinstance(p,Person))

#####################

def fn(item):
	return item >=0

print(list(filter(fn,[0,1,-1,2,-2])))
print
print(list(filter(lambda item:item>=0,[0,1,-1,2,-2])))

#####################
print
def fn2(item):
	return item **2
print(list(map(fn2,[1,2,3,4,-5])))	
print
print(list(map(lambda item:item**2,[1,2,3,4,-5])))
#####################
print
print(list(zip([1,2,3],[4,5,6])))
print(list(zip([1,2,3],[4,5,6],[100,200,300])))
print(list(zip("abc","123")))
#####################








