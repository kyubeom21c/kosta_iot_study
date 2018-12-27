package test.com;

import java.util.Random;

public class Test01Main6 {

	public static void main(String[] args) {
		System.out.println("Thread...Runnable");
		
		//1.알파벳을 0.5초당 한번씩 10번 출력하는
		new Thread() {
			public void run() {
				for (char i = 'A'; i < 'K'; i++) {
					System.out.println(i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
		
		
		//2.날자 0.5초당 한번씩 10번 출력하는
		Thread t = new Test04ThreadEx();
		t.start();
		
		
		//3.렌덤한 정수 0.5초당 한번씩 10번 출력하는
		Runnable r = new Runnable() {
			@Override
			public void run() {
				Random r = new Random();
				for (int i = 0; i < 10; i++) {
					System.out.println(r.nextInt(100));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		new Thread(r).start();
		
		//스레드를 구현하시오.
		//조건>> 각각 다른 방식으로 3가지 이상
		
		System.out.println("end main...");
	}

}
