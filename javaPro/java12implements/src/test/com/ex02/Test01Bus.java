package test.com.ex02;

public class Test01Bus extends Test01Car {

	boolean transfer;
	String cardReader;
	
	public void broadcast() {
		System.out.println("broadcast()...");
	}
	
	public void bell() {
		System.out.println("bell()...");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
}
