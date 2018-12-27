#!/usr/bin/env python
# -*- coding: utf-8 -*-
import os
print("os open")
#os.O_RDONLY>>readonly
#os.O_WOONLY>>writeonly
fd = os.open("test29.txt",os.O_RDWR | os.O_APPEND|os.O_CREAT)


print
txt = "My name is Yangssem\n"
txt_length = os.write(fd,txt.encode())
print(txt_length)
print(type(txt_length))

os.close(fd)

