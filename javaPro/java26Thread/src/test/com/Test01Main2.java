package test.com;

import java.util.Date;

public class Test01Main2 {

	public static void main(String[] args) {
		System.out.println("Thread...Runnable");
		

		//extends Thread
		Thread tex = new Test01ThreadEx();
		tex.start();
		
		System.out.println("end main...");
	}

}
