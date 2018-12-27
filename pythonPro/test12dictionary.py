#!/usr/bin/env python
# -*- coding: utf-8 -*-
import sys
print("dict dictionary")

#key, value
dic = {'name':'yangssem','tel':'010'}
print(type(dic))
print(dic)
######################

print(dic['name'])
print(dic['tel'])
print(dic.get('name'))
print(dic.get('tel'))
######################

print('name' in dic)
print('name2' in dic)

######################
dic = {}
print(dic)
######################

dic = {1:'aaa',2:'bbb'}
dic[3] = 'yangssem'
dic['addr'] = 'seoul'
dic['lst'] = [1,2,3]
dic['tp'] = (1,2,3)
dic['dt'] = {'email':'aaa@aaa.com'}
print(dic)
######################


print(dic['lst'] [0])
print(dic['tp'] [0])
print(dic['dt'] ['email'])
######################

print(dic.keys())
print(type(dic.keys()))
######################
print(dic.values())
print(type(dic.values()))
######################
print(dic.items())
print(type(dic.items()))
######################

for key in dic:
	print(key,dic[key])
######################
print(dic.get('100'))#None
######################
dic.clear()# dic = {}
print(dic)
######################


