package test.com;

import java.util.Date;

public class Test01Main {

	public static void main(String[] args) {
		System.out.println("Thread...Runnable");
		
		//1.Thread anonymous inner class
		Thread t = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(new Date());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//병렬처리 구현 메소드>>> run()
		t.start();//병렬처리명령
		
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(new Date().getTime());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		
		System.out.println("end main...");
	}

}
