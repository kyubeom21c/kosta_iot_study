#!/usr/bin/env python
# -*- coding: utf-8 -*-
import sys
print("set()")

s = set([1,2,3,1,2,3])
print(type(s))
print(s)
##########

s = set((11,12,13,11,12,13))
print(type(s))
print(s)
##########

lst = list((1,2,3))
print(type(lst))
print(lst)
##########

tp = tuple([1,2,3])
print(type(tp))
print(tp)
##########

s = set((11,22,33,11,22,33))
print(type(s))
print(s)
##########

s = set((11,22,33,11,22,33))
s.add(99)
s.remove(22)
print(s)
##########

s = set((11,22,33,11,22,33))
s.update((77,88,99))
print(s)
##########

s1 = set([11,22,33])
s2 = set([22,33,44])
print("s1&s2:",s1&s2,type(s1&s2))
print("s1.intersection(s2):",s1.intersection(s2))
##########

print("s1|s2:",s1|s2,type(s1|s2))
print("s1.union(s2):",s1.union(s2))
##########

print("s1-s2:",s1-s2,type(s1-s2))
print("s1.difference(s2):",s1.difference(s2))
##########






