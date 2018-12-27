package test.com;

import test.com.Test01Member.Inner;

public class Test01Main {

	// 1.속성
	// 2.생성자
	// 3.메소드
	// 4.초기화블럭

	// 5.내부클래스(중첩클래스)-외부클래스의 자원을
	// 객체 생성없이 쓰고자 할때
	// 멤버내부클래스,스테틱내부클래스,
	// 로컬내부클래스,익명내부클래스

	public static void main(String[] args) {
		System.out.println("inner class");

		// 1.멤버내부클래스

		Test01Member member = new Test01Member();
		member.test();
//		Inner in = new Test01Member().new Inner();
		Inner in = member.new Inner();
		in.testInner();

		System.out.println("=============");

		// 2.스테틱내부클래스
		Test02static st = new Test02static();
		st.test();
		System.out.println(Test02static.Inner.tel2);
		test.com.Test02static.Inner sin = new Test02static.Inner();
		System.out.println(sin.email);

		System.out.println("=============");

		// 3.로컬내부클래스
		Test03Local local = new Test03Local();
		local.test();

		System.out.println("=============");
		
		
		// 4.익명내부클래스
		/*final */String str = "hello";
//		str = "hello222";
		Test04Anonymous anony = new Test04Anonymous() {
			public void testInner() {
				System.out.println("testInner()..." + name);
			}

			@Override
			public void test() {
				testInner();
//				str = "hello222";
				System.out.println(str);
			}
		};
		anony.test();

	}// end main()

	// 4.익명내부클래스
	Test04Anonymous anony = new Test04Anonymous() {
		public void testInner() {
			System.out.println("testInner()..." + name);
		}

		@Override
		public void test() {
			testInner();
		}
	};

}
