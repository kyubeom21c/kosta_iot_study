#!/usr/bin/env python
# -*- coding: utf-8 -*-
import sys

print('while')

i=0
while True:
	i +=1
	if i==5 : continue
	if i==10 : break
	name = raw_input("input name:")
	print("while" ,i)
	print("Hello {} ".format(name))

