package test.com;

import test.com.Test01Member.Inner;

public class Test01Main {

	// 1.�Ӽ�
	// 2.������
	// 3.�޼ҵ�
	// 4.�ʱ�ȭ��

	// 5.����Ŭ����(��øŬ����)-�ܺ�Ŭ������ �ڿ���
	// ��ü �������� ������ �Ҷ�
	// �������Ŭ����,����ƽ����Ŭ����,
	// ���ó���Ŭ����,�͸���Ŭ����

	public static void main(String[] args) {
		System.out.println("inner class");

		// 1.�������Ŭ����

		Test01Member member = new Test01Member();
		member.test();
//		Inner in = new Test01Member().new Inner();
		Inner in = member.new Inner();
		in.testInner();

		System.out.println("=============");

		// 2.����ƽ����Ŭ����
		Test02static st = new Test02static();
		st.test();
		System.out.println(Test02static.Inner.tel2);
		test.com.Test02static.Inner sin = new Test02static.Inner();
		System.out.println(sin.email);

		System.out.println("=============");

		// 3.���ó���Ŭ����
		Test03Local local = new Test03Local();
		local.test();

		System.out.println("=============");
		
		
		// 4.�͸���Ŭ����
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

	// 4.�͸���Ŭ����
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
