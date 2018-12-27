package test.com;

import test.com.member.AAA;
import test.com.member.Test01MemberVO;

public class Test01main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main...");
		
		Test01MemberVO tm = new Test01MemberVO();
		System.out.println(tm);
		System.out.println(tm.num);
		System.out.println(tm.id);
		System.out.println(tm.pw);
		System.out.println(tm.name);
		System.out.println(tm.tel);
		
		AAA a = new AAA(tm);
		
		Test01MemberVO tm2 = new Test01MemberVO(
						33, "x", "xx", "xxx", "xxxx");
		System.out.println(tm2);
		System.out.println(tm2.num);
		System.out.println(tm2.id);
		System.out.println(tm2.pw);
		System.out.println(tm2.name);
		System.out.println(tm2.tel);
	}//end main()

}//end class
