#!/usr/bin/env python
# -*- coding: utf-8 -*-
print("class multi extends")

class Korean:
	ssn = "961113-2345678"
	def __init__(self):
		print("Korean __init__")
	def getLocation(self):
		return "korea"


class Person:
	pname = "kim"
	def __init__(self):
		print("Person__init__")
	def getPname(self):
		return self.pname
	def setPname(self,pname):
		self.pname = pname

######################
class Students(Korean,Person):
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
print(st.getLocation())
print(st.ssn)
######################	
print(Students.__bases__)
print(issubclass(Students,Korean))
######################	

	
