package test.com;

import java.util.Date;

import test.go.Test03Board;

public class Test03BoardMain {

	
	public static void main(String[] args) {
		System.out.println("board main...");

		Test03Board tb = new Test03Board();
		System.out.println(tb);
//		System.out.println(tb.title);
//		System.out.println(tb.content);
//		System.out.println(tb.writer);
//		System.out.println(tb.wDate);
		
//		tb.title = "aaaa";
//		tb.content = "bbbb";
//		tb.writer = "kim";
//		tb.wDate = new Date();
//		System.out.println(tb.title);
//		System.out.println(tb.content);
//		System.out.println(tb.writer);
//		System.out.println(tb.wDate);
		
		
		//동일한 이름의 생성자(메소드)를 여러개 정의할때
		//매개변수의 타입,개수,순서를 다르게 해주어야한다.
		//이를 메소드와 생성자의 오버로딩 이라고 한다.
		Test03Board tb2 = new Test03Board("aaaa");
		Test03Board tb3 = new Test03Board(33);
		Test03Board tb4 = new Test03Board(33,44);
		Test03Board tb5 = new Test03Board(33,"kim");
		Test03Board tb6 = new Test03Board("kim",33);
		
		
	}//end main()

}//end class
