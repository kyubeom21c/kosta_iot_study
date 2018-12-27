package test.com;

import java.util.Random;

public class Test01Main6 {

	public static void main(String[] args) {
		System.out.println("Thread...Runnable");
		
		//1.���ĺ��� 0.5�ʴ� �ѹ��� 10�� ����ϴ�
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
		
		
		//2.���� 0.5�ʴ� �ѹ��� 10�� ����ϴ�
		Thread t = new Test04ThreadEx();
		t.start();
		
		
		//3.������ ���� 0.5�ʴ� �ѹ��� 10�� ����ϴ�
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
		
		//�����带 �����Ͻÿ�.
		//����>> ���� �ٸ� ������� 3���� �̻�
		
		System.out.println("end main...");
	}

}
