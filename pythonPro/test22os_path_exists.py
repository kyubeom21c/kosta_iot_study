#!/usr/bin/env python
# -*- coding: utf-8 -*-

import os
print("os path exists")

os.system("pwd")
os.system("ls -l")
	
result = os.path.exists("/home/pi/pythonPro")
print("os.path.exists",result)
result = os.path.exists("/home/pi/pythonPro/test01hello.py")
print("os.path.exists",result)
#####################

result = os.path.dirname("/home/pi/pythonPro")
print("os.path.dirname",result)
result = os.path.dirname("/home/pi/pythonPro/test01hello.py")
print("os.path.dirname",result)
#####################

result = os.path.isfile("/home/pi/pythonPro")
print("os.path.isfile",result)
result = os.path.isfile("/home/pi/pythonPro/test01hello.py")
print("os.path.isfile",result)
#####################

result = os.path.getsize("/home/pi/pythonPro")
print("os.path.getsize",result)
result = os.path.getsize("/home/pi/pythonPro/test01hello.py")
print("os.path.getsize",result)
#####################
#docs site
#https://docs.python.org/2.7/library/os.path.html
#https://docs.python.org/3/library/os.path.html
