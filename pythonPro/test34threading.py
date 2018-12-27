#!/usr/bin/python3
# -*- coding: utf-8 -*-
import threading

class Messenger(threading.Thread):
	def run(self):
		for _ in range(10):
			#활성화 된 스레드이 름 획득.
			print(threading.currentThread().getName())
			
#스레 드 객 체 생성시 에 이 름설정가능.		
send = Messenger(name='Send message : yangssem')
#스레 드 객 체 생 성후 에 이 름설 정가능.
receive = Messenger()
receive.setName('Receive message : kim')

#스레드 의  시 작명령.
send.start()
#send.join()#send스레드 가 종료할때까 지 기다 림 명령.주 석풀고 isAlive() 로 확 인가능.
receive.start()

print("send:",send.isAlive())#스레드  가 아 직 실행중인 지 여 부 반환..
print("receive:",receive.isAlive())

print("1..",threading.enumerate())#활성화 된모 든스레드목 록
print("2..",threading.activeCount())#활성화 된 스레 드 객체 수,여기서 는메 인포 함3
print("3..",threading.currentThread())#스레드 를 컨트롤하 는 스레드객체,여기서 는 메개인스드레


#Send message : yangssem
#Send message : yangssem
#Send message : yangssem
#Receive message : kim
#Send message : yangssem
#Receive message : kim
#...
#Receive message : kim
#Receive message : kim
