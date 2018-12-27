#!/usr/bin/env python
# -*- coding: utf-8 -*-

import RPi.GPIO as GPIO
import time

print("RPi.GPIO LED")

GPIO.setmode(GPIO.BCM)

print("RPi.GPIO setup OK")

GPIO.setup(17,GPIO.OUT)
GPIO.output(17,False)
GPIO.setup(4,GPIO.OUT)
GPIO.output(4,False)

#for i in range(10):
while True:
	print("ON")
	GPIO.output(17,True)
	GPIO.output(4,True)
	time.sleep(1)
	
	print("OFF")
	GPIO.output(17,False)
	GPIO.output(4,False)
	time.sleep(1)
	
print("end...")
GPIO.cleanup()

