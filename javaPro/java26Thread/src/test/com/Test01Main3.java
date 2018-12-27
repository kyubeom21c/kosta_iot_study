package test.com;

import java.util.Date;

public class Test01Main3 {

	public static void main(String[] args) {
		System.out.println("Thread...Runnable");
		

		//member inner class extends Thread
		Test02InnerThreadEx outter = new Test02InnerThreadEx();
		outter.test();
		
//		Test02InnerThreadEx.Inner in = new Test02InnerThreadEx().new Inner();
		Thread in = new Test02InnerThreadEx().new Inner();
		in.start();
		
		System.out.println("end main...");
	}

}
