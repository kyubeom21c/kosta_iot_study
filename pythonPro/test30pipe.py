#!/usr/bin/env python
# -*- coding: utf-8 -*-
import os
print("os pipe")

fd_receive,fd_transmit = os.pipe()

print("fd_receive",fd_receive)
print("fd_transmit",fd_transmit)

data = "yangssem12345"
date_length = os.write(fd_transmit,data.encode())
print("date_length",date_length)

print("The pipe os.read():",os.read(fd_receive,1024))







