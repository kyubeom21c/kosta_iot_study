#!/usr/bin/env python
# -*- coding: utf-8 -*-

print("file open")

#read >>> r
f = open("test14.txt","r")
while True:
	data = f.readline()
	if not data:
		break
	print(data)

print("\n")
####################
x = 10
y = "kim"
print("%d %s" %(x,y))
####################

#write >>> w
fw = open("test14fw.txt","w")
#0 aaa
#1 bbb
#...
names = ['aaa','bbb','ccc','ddd']
for i in range(len(names)):
	data = "%d %s\n" %(i,names[i])
	fw.write(data)
####################
#read >>> r
fw = open("test14fw.txt","r")
lst = fw.readlines()
print(type(lst))
print(lst)
print("\n")
####################
f.close()
fw.close()









