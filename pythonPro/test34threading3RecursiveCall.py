#!/usr/bin/python3
# -*- coding: utf-8 -*-
import threading
import time

def test():
	print("test()...")
	print(threading.currentThread().getName())
	print(threading.enumerate())
	time.sleep(1)
	t = threading.Thread(target=test)
	t.start()
	


test()
print("end...main")
#######################################
#test()...
#MainThread
#[<_MainThread(MainThread, started 1996218384)>]
#test()...
#end...main
#Thread-1
#[<_MainThread(MainThread, stopped 1996218384)>, <Thread(Thread-1, started 1987908720)>]
#test()...
#Thread-2
#[<_MainThread(MainThread, stopped 1996218384)>, <Thread(Thread-2, started 1977611376)>]
#test()...
#Thread-3
#....
#...
#######################################
