#!/usr/bin/python3
# -*- coding: utf-8 -*-


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
import sys,json,threading,time

#GET
import requests

# 호스트, 포트와 버퍼 사이즈를 지정
HOST = '192.168.0.106'
PORT = 56789
BUFSIZE = 1024
ADDR = (HOST, PORT)

# 소켓 객체를 만들고..
serverSocket = socket(AF_INET, SOCK_STREAM)

# 서버 정보를 바인딩
serverSocket.bind(ADDR)

# 요청을 기다림(listen)
serverSocket.listen(10)

def test():
	print("test()...")
	print(threading.currentThread().getName())
	print(threading.enumerate())
	clientSocket, addr_info = serverSocket.accept()
	print("clientSocket:",clientSocket)
	time.sleep(1)
	t = threading.Thread(target=test)
	t.start()

	while True:
		try:
			data=clientSocket.recv(BUFSIZE)

			print(data.decode())
			
			#GET
			get_url = "http://192.168.0.191:8090/pythonjson/json_sensorStatus.do"
			get_url += "?num="+data.decode()
			req = requests.get(get_url)
			print(req.content)#bytes
			json_data=json.loads(str(req.content,"utf-8"))
			print("json_data:",json_data)
			print("type(json_data):",type(json_data))
			print(json_data["num"])
			print(json_data["led"])
			
			clientSocket.send(req.content);#bytes
		except KeyboardInterrupt:
			
			serverSocket.close()
			sys.exit()

print('==============================================')
print('채팅 서버를 시작합니다. %s 포트로 접속을 기다립니다.' % str(PORT))
print('==============================================')
test()

