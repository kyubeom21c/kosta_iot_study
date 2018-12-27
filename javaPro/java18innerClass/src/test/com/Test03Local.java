package test.com;

public class Test03Local {
	String name;
	
	public void test() {
		System.out.println("test()....");
		final String str = "aaa";
		class Inner{
			public int su;
			public void testInner() {
//				str = "bbb";
				System.out.println(str);
				System.out.println("testInner()..."+name);
			}
		}
		Inner in = new Inner();
		in.testInner();
	}

}
