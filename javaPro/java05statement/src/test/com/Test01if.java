package test.com;

public class Test01if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("if");

		// 조건에 대한 분기처리
		boolean b = (8 & 2) <= 10;
		if (5 == 5) {
			System.out.println("kim");
			System.out.println("kim");
			System.out.println("kim");
			System.out.println("kim");
			if (b) {
				System.out.println("lee");
				if (b) {
					System.out.println("lee");
				}
			}
		}

		if (b) {
			System.out.println("lee");
		}

	}

}
