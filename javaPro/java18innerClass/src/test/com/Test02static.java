package test.com;

public class Test02static {
	
	public void test() {
		Inner.tel2 = "080";
		Inner.testInner();
	}
	
	public static class Inner{
		int email;
		static final String TEL = "010";
		static String tel2 = "010";
		
		public static void testInner() {
			System.out.println("static testInner()...");
		}
		
	}

}
