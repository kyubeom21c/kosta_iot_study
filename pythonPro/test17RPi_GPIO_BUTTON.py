#!/usr/bin/env python
# -*- coding: utf-8 -*-

import RPi.GPIO as GPIO
import time

print("RPi.GPIO BUTTON")

GPIO.setmode(GPIO.BCM)

print("RPi.GPIO setup OK")

GPIO.setup(24,GPIO.IN,pull_up_down=GPIO.PUD_UP)
try:
	while True:
		inputValue = GPIO.input(24)
		print(inputValue)
		if(inputValue== False):
			print("button")
			time.sleep(0.3)
		time.sleep(0.5)
except KeyboardInterrupt:	
	GPIO.cleanup()#ctrl+c
	print("cleanup")

print("end...")
