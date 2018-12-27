package test.go;

import java.util.Date;

public class Test03Board {
	
	//public  default  protected  private
	String title;//제목
	String content;
	String writer;
	Date wDate;
	
	//생성자의 주목적:속성(필드변수)의 초기화
	public Test03Board() {
		title = "제목";
		content = "내용";
		writer = "홍길동";
		wDate = new Date();
	}

	public Test03Board(String x) {
		title = x;
		System.out.println(title);
		System.out.println(content);
		System.out.println(writer);
		System.out.println(wDate);
	}
	public Test03Board(int x) {
//		title = x;
//		content = y;
		System.out.println(title);
		System.out.println(content);
		System.out.println(writer);
		System.out.println(wDate);
	}
	public Test03Board(int x,int y) {
//		title = x;
//		content = y;
		System.out.println(title);
		System.out.println(content);
		System.out.println(writer);
		System.out.println(wDate);
	}
	public Test03Board(int x,String y) {
//		title = x;
//		content = y;
		System.out.println(title);
		System.out.println(content);
		System.out.println(writer);
		System.out.println(wDate);
	}
	public Test03Board(String x,int y) {
//		title = x;
//		content = y;
		System.out.println(title);
		System.out.println(content);
		System.out.println(writer);
		System.out.println(wDate);
	}

}
