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

port='/dev/ttyUSB0'  #메 뉴 >  도 구>  시리얼포 트
baudrate=9600
se = serial.Serial(port,baudrate)

while True:	
	print("input num:")
	num = input()
	se.write(num.encode())
