#!/usr/bin/python3
# -*- coding: utf-8 -*-

#방법1. 
#먼 저  라즈베리파이 에 아두이노 를  설치한다.
#sudo apt-get install -y arduino
#X-Windows > Top Menu > 개 발  > arduino IDE 실행.
#아두이 노 UNO > USB 시리얼케이블연결.
#메 뉴 >  도 구> 보드(arduino UNO)확 인
#메 뉴 >  도 구>  시리얼포 트 > 예: /dev/ttyUSB1 확인.
#새파 일>소스코 드작성..첨부소 스참고:test36arduino_pythonSerial.ino
#컴파 일> 업로 드  후   확인.


#방법2
#윈도 우pc 에 윈도우 용  아두이 노IDE 에 서 
#새파 일>소스코 드작성..첨부소 스참고:test36arduino_pythonSerial.ino
#컴파 일> 업로 드  후  라즈베리파 이 usb시리얼포트 로 연결해 서  확인.
#아 래소스에 서  usb시리얼포트  바뀔 수있으 니  오류발생 시 확인..

import serial

print("arduino serial")

port='/dev/ttyUSB1'  #메 뉴 >  도 구>  시리얼포 트
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
