package test.com;


public class Test01static {

	int num;
	
	static String name = "lee";
	
	public static final double AVG = 99.99;
	
	public static class Note{
		static String name2 = "lee";
	}
	
	{
		num = 99;
		name = "kim";
	}
	
	static {
		name = "kim";
	}
	
	public void test() {
		System.out.println("test()...");
		test2();
		aaa();
		System.out.println(Integer.MIN_VALUE);
	}
	
	public static void aaa() {
		
	}
	
	public static void test2() {
		System.out.println("test2()...");
		aaa();
//		test();//new 해서 써야함
//		System.out.println(num);//new 해서 써야함
		System.out.println(name);
	}
}
