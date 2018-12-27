package test.com;

public class Test01Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("interface & implements");
		
		System.out.println(Test01xxx.NUM);
		Test01xxx.test4();
		
		
		//상속이 전제로된 다형성
		Test01xxx tx = new Test01zzz();
		tx.test();
		tx.test2();
		tx.test3();
		System.out.println(Test01zzz.NUM);
		
		Test01xxx tx2 = new Test01xxx() {
			@Override
			public void test() {
				System.out.println("aaaaaaaaa");
			}
			@Override
			public void test2() {
				
			}
			public void aaa() {
				
			}
			
		};
		tx2.test();
		
	}

}
