#!/usr/bin/env python
# -*- coding: utf-8 -*-

import RPi.GPIO as GPIO
import time

print("RPi.GPIO BUTTON")

GPIO.setmode(GPIO.BCM)

print("RPi.GPIO setup OK")

GPIO.setup(24,GPIO.IN,pull_up_down=GPIO.PUD_UP)
GPIO.setup(17,GPIO.OUT)
GPIO.output(17,False)
GPIO.setup(4,GPIO.OUT)
GPIO.output(4,False)
try:
	while True:
		inputValue = GPIO.input(24)
		print(inputValue)
		
		if(inputValue== True):
			print("button ON")
			time.sleep(0.3)
			GPIO.output(17,True)
			GPIO.output(4,True)
		else:
			print("button OFF")
			GPIO.output(17,False)
			GPIO.output(4,False)
		time.sleep(0.5)
except KeyboardInterrupt:	
	GPIO.cleanup()#ctrl+c
	print("cleanup")

print("end...")
