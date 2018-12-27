package test.com;

public class Test01Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("operator");

		// (산술우선연산), (케스팅), .포함연산자
		// + - * /(정수연산시 몫) %나머지
		System.out.println(10 / 7);
		System.out.println(10.0 / 7.0);
		System.out.println(10 % 7);
		System.out.println(10.0 % 7.0);

		// 비트연산 & | ^
		// 0000 1111 : 15
		// 0000 0010 : 2
		// ^ 0000 1101 : 13
		System.out.println(8 & 2);
		System.out.println(8 | 2);
		System.out.println(15 | 2);
		System.out.println(15 ^ 2);

		// 논리연산 true,false : & | ^,&&,||
		System.out.println(true & true);
		System.out.println(true & false);
		System.out.println(true | false);
		System.out.println(false ^ false);
		System.out.println("============");
		System.out.println(false && true);
		System.out.println(true || false);

		// 비교연산:결과가 반드시boolean 타입
		// ==,!=,<,>,<=,>=
		System.out.println(5 == 5);
		System.out.println(5 != 5);
		System.out.println(5 < 5);
		System.out.println(5 > 5);
		System.out.println(5 <= 5);
		System.out.println(5 >= 5);
		System.out.println("============");
		System.out.println(5 >= 5 || 5 <= 5);

		// 대입연산(할당연산) : =, +=,-=,*=,/=,%=,&=,|=,^=
		int x = 10;
		System.out.println(x);
		x = x + 3;
		System.out.println(x);
		x += 3;
		System.out.println(x);
		int y = 7;
		y = (y + 3) & 3;
		// 1010
		// 0011
		// 0010
		System.out.println(y);
		int z = 7;
		z = z + (3 & 3);
		// 0011
		// 0011
		// 0011
		System.out.println(z);

		// 쉬프트연산(비트이동연산):>>,<<,>>>
		// 8>>2: 0010
		System.out.println(8 >> 2);
		// 1<<3: 1000
		System.out.println(1 << 3);
		// -8>>>2: 0010 무조건 양수결과
		System.out.println(-898765432 >>> 2);
		
		//증감연산 : ++ --
		int a = 10;
		int b = a--;
		System.out.println(a);
		System.out.println(b);
		
		//삼항연산(분기처리용) 조건식(비교,논리)? 참일때:거짓일때
		System.out.println(5==50?100:0);
		System.out.println(true&false?"kim":"lee");
		System.out.println(true&5==50?"kim":"lee");
		int kor = 77;
		System.out.println(kor>=90?'A':'B');
		char grade = kor>=90 && kor<=100?'A':kor>=80?'B':'C';
		System.out.println(grade);
		
		
		//,(열거형연산자) new  ... :(goto)
		
	}//end main()

}//end class
