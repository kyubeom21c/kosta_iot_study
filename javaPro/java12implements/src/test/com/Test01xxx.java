package test.com;

public interface Test01xxx {

	//속성 : 무조건 static final 상수
	static final int NUM = 234567890;
	
	public /*abstract*/ void test();
	public void test2();
	
	public default void test3() {
		System.out.println("test3()..");
	}
	public static void test4() {
		System.out.println("test4()..");
	}
}
