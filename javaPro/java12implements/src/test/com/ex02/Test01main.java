package test.com.ex02;

public class Test01main {
	Test01Car c;
	public void test(Test01Car c) {
		System.out.println("test()....");
		c.run();
		c.start();
		c.stop();
	}
	
	public Test01main() {
		// TODO Auto-generated constructor stub
	}
	public Test01main(Test01Car c) {
		this.c = c;
	}

	public static void main(String[] args) {
		System.out.println("hello");
		
		Test01main tm = new Test01main();
		
		tm.test(new Test01Car() {
			@Override
			public void stop() {
				System.out.println("***stop()....");
			}
		});
		
		tm.test(new Test01Bus());
		tm.test(new Test01Taxi());
		
		
//		new BufferedReader(new StringReader("ddd"));
		new Test01main(new Test01Car() {
			
			@Override
			public void stop() {
				// TODO Auto-generated method stub
				
			}
		});
		new Test01main(new Test01Bus());
		new Test01main(new Test01Taxi());
		
	}

}
