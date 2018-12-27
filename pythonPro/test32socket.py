#!/usr/bin/python3

#OSError: [Errno 98] Address already in use>>>아 래 해결법.
#pi@raspberrypi:~/pythonPro $ sudo apt install -y lsof
#pi@raspberrypi:~/pythonPro $ sudo lsof -i :56789
#COMMAND  PID USER   FD   TYPE DEVICE SIZE/OFF NODE NAME
#python3 4519   pi    3u  IPv4  21354      0t0  TCP 192.168.0.106:56789 (LISTEN)
#python3 4519   pi    4u  IPv4  21355      0t0  TCP 192.168.0.106:56789
#pi@raspberrypi:~/pythonPro $ sudo kill -9 4519
#[1]+  죽었음               python3 test35socket_urllib.py
#pi@raspberrypi:~/pythonPro $ sudo lsof -i :56789

#socket 과 select 모듈 임포트
from socket import *
from select import *
import sys
from time import ctime


# 호스트, 포트와 버퍼 사이즈를 지정
HOST = '192.168.0.106'
PORT = 56789
BUFSIZE = 1024
ADDR = (HOST, PORT)

# 소켓 객체를 만들고..
serverSocket = socket(AF_INET, SOCK_STREAM)
#serverSocket.close()
# 서버 정보를 바인딩
serverSocket.bind(ADDR)

# 요청을 기다림(listen)
serverSocket.listen(10)
connection_list = [serverSocket]
print('==============================================')
print('채팅 서버를 시작합니다. %s 포트로 접속을 기다립니다.' % str(PORT))
print('==============================================')
clientSocket, addr_info = serverSocket.accept()
print(clientSocket)


while connection_list:
	try:
		data=clientSocket.recv(BUFSIZE)

		print(data.decode())
		message = sys.stdin.readline()
		clientSocket.send(message.encode())
	except KeyboardInterrupt:
        
		serverSocket.close()
		sys.exit()
