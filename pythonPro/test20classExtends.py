#!/usr/bin/env python
# -*- coding: utf-8 -*-
print("class extends")

class Person:
	pname = "kim"
	def __init__(self):
		print("Person__init__")
	def getPname(self):
		return self.pname
	def setPname(self,pname):
		self.pname = pname

p = Person()
p.setPname("lee")
print(p.pname)
print(p.getPname())
######################
class Students(Person):
	sname = "yang"
	def __init__(self):
		print("Students__init__")
	def getSum(self,x,y):
		return x+y
st = Students()
print(st.sname)
print(st.pname)
st.setPname("lee")
print(st.getPname())
print(st.getSum(100,200))
######################	

print(Person.__bases__)
print(Students.__bases__)
######################	

print(issubclass(Students,Person))
print(issubclass(Person,Students))

######################	
	
