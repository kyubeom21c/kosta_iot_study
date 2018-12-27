#!/usr/bin/env python
# -*- coding: utf-8 -*-
import sys
import time
import datetime

print('time')
time.sleep(3)

print("end sleep")
print(datetime.datetime.now())

for i in range(10):
	print(i)
	time.sleep(1)
