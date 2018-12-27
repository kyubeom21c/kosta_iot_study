package test.com;

public class Test01Member {

	private int num;
	
	public void test() {
//		Inner in = new Inner();
		System.out.println("test()...."/*+in.email*/);
	}
	
	public class Inner{
		int email;
		
		public Inner() {
			System.out.println("Inner()...");
			test();
		}
		
		public void testInner() {
			System.out.println("testInner()..."+num);
			test();
		}
		
	}
	
	
}
