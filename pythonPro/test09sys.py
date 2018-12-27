#!/usr/bin/env python
# -*- coding: utf-8 -*-
import sys
print("sys")


# python test09ss.py 11 22 33 44...
print("len(sys.argv):",len(sys.argv))

if len(sys.argv)>3:
	print(sys.argv[0])
	print(sys.argv[1])
	print(sys.argv[2])
	print(sys.argv[3])

print("input name:")
name = sys.stdin.readline()
print("name:",name)

