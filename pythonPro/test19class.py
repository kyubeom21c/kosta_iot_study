#!/usr/bin/env python
# -*- coding: utf-8 -*-
print("class")

#MemberVO
class MemberVO:
	userName = "yangssem"
	def __init__(self):
		print("MemberVO __init__")

m = MemberVO()
print("m.userName",m.userName)
print

###################

class ScoreVO:
	def __init__(self,name,kor,eng,math):
		print("ScoreVO __init__")
		self.name = name
		self.kor = kor
		self.eng = eng
		self.math = math
	def getName(self):
		return self.name

	def setName(self,name):
		self.name = name
	
s = ScoreVO("kim",99,88,77)
print(s.name)
print(s.kor)
print(s.eng)
print(s.math)
print(vars(s))
print(type(vars(s)))
s.setName("yangssem")
print("s.getName()",s.getName())
##########################
