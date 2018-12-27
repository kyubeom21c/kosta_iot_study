#socket 모듈을 임포트
from socket import *
from select import select
import sys
import serial
import time
import json

port='/dev/ttyUSB1'  #메 뉴 >  도 구>  시리얼포 트
baudrate=9600
se = serial.Serial(port,baudrate)

# 호스트, 포트와 버퍼 사이즈를 지정
HOST = '192.168.0.106'
PORT = 56789
BUFSIZE = 1024
ADDR = (HOST, PORT)

# 소켓 객체를 만들고
clientSocket = socket(AF_INET, SOCK_STREAM)

# 서버와의 연결을 시도
try:
    clientSocket.connect(ADDR)
    

except Exception as e:
    print('채팅 서버(%s:%s)에 연결 할 수 없습니다.' % ADDR)
    sys.exit()
print('채팅 서버(%s:%s)에 연결 되었습니다.' % ADDR)


# 무한 루프를 시작
while True:
	time.sleep(1)
	num = b'1'#b'1',b'2',b'3',b'4'
	clientSocket.send(num)
	data=clientSocket.recv(BUFSIZE)
	print(data.decode())
	se.write(data)
	led1 = json.loads(data.decode())["led1"]
	led2 = json.loads(data.decode())["led2"]
	print(led1)
	print(led2)
	


