#!/usr/bin/python3
# -*- coding: utf-8 -*-
import threading

def test():
	for _ in range(10):
		print("test()...")

t = threading.Thread(target=test)
t.start()
#test()

###############################################

def test2(x,y):	
	for _ in range(10):
		print("test2()...",x+y)
		
t2 = threading.Thread(target=test2,args=(100,200))
t2.start()
