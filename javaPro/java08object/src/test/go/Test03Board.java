package test.go;

import java.util.Date;

public class Test03Board {
	
	//public  default  protected  private
	String title;//����
	String content;
	String writer;
	Date wDate;
	
	//�������� �ָ���:�Ӽ�(�ʵ庯��)�� �ʱ�ȭ
	public Test03Board() {
		title = "����";
		content = "����";
		writer = "ȫ�浿";
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
