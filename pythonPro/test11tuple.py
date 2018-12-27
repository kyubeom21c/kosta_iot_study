#!/usr/bin/env python
# -*- coding: utf-8 -*-
import sys
print("tuple")

#list >>> read, insert,update,delete OK


#tuple >>> read only

tp = ()
tp = (0,0,0,0)
tp = (1,2,3,4)
tp = (1,2,3,(11,22))
tp = (1,2,3,(11,22),[99,88])

print(type(tp))
print(tp)
###################
#tuple >>> read only
#del tp[0]
#tp[0] = 100
#tp[1:3] = (77,88)
#tp.append(999)
tp = tp + (77,88)
print(tp)
###################
tp = tp*2
print(tp)
###################

tp = (1,2,3,('aaa','bbb'))

tp = tp[1:3]
print(tp)
###################
