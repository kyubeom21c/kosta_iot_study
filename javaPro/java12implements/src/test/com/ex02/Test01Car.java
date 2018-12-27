package test.com.ex02;

public abstract class Test01Car {

	int doorCount;
	double power;
	
	public void run() {
		System.out.println("run()...");
	}
	
	public void start() {
		System.out.println("start()...");
	}
	
	public abstract void stop() ;
	
}
