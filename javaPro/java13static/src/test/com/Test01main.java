package test.com;

public class Test01main {
	
	public void aaa() {
		
	}
	
	public static void ccc() {
		
	}

	public static void main(String[] args) {
		System.out.println("static");

		Test01static st = new Test01static();
		st.num = 100;
		Test01static.name = "kim";
		System.out.println(st.num);
		System.out.println(Test01static.name);
		
		st.test();
		Test01static.test2();
		
		ccc();
		
		new Test01main().aaa();
	}

}
