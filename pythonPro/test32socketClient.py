#socket 모듈을 임포트
from socket import *
from select import select
import sys


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


def prompt():
    sys.stdout.write('<나> ')
    sys.stdout.flush()
	

# 무한 루프를 시작
while True:
    message = sys.stdin.readline()
    clientSocket.send(message.encode())
    data=clientSocket.recv(BUFSIZE)
    print(data.decode())
    prompt()




