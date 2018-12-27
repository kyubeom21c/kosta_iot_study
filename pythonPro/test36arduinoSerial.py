#!/usr/bin/python3
# -*- coding: utf-8 -*-
#pip install pyserial
#먼 저  라즈베리파이 에 아두이노 를  설치한다.
#sudo apt-get install -y arduino
#X-Windows > Top Menu > 개 발  > arduino IDE 실행.
#아두이 노 UNO > USB 시리얼케이블연결.
#메 뉴 >  도 구> 보드(arduino UNO)확 인
#메 뉴 >  도 구>  시리얼포 트 > 예: /dev/ttyUSB0 확인.

import serial

print("arduino serial")

port='/dev/ttyUSB0'  #메 뉴 >  도 구>  시리얼포 트
baudrate=9600
se = serial.Serial(port,baudrate)

while True:
	if se.readable():
		byteStr = se.readline()
		print("===1========")
		print(type(byteStr))		#<class 'bytes'>
		print(byteStr)					#b'2\r\n'
		
		print("===2========")		
		data = byteStr.decode()
		print(type(data))				#<class 'str'>
		print(data)						#2 밑 에  엔터 가 먹혀있음.
		
		print("===3========")
		print("n or r remove")	#/n remove
		print(data[:len(data)-1])	#2
		print("..........................")

		#print(data+100)#error 
		print(int(data)+100) 	#102
