package test.com;

public class Test01Main5 {

	public static void main(String[] args) {
		System.out.println("Thread...Runnable");
		
		//implements Runnable 
		Runnable r = new Test03RunnableImpl();
		new Thread(r).start();
		
		System.out.println("end main...");
	}

}
