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
		
		
		//������ �̸��� ������(�޼ҵ�)�� ������ �����Ҷ�
		//�Ű������� Ÿ��,����,������ �ٸ��� ���־���Ѵ�.
		//�̸� �޼ҵ�� �������� �����ε� �̶�� �Ѵ�.
		Test03Board tb2 = new Test03Board("aaaa");
		Test03Board tb3 = new Test03Board(33);
		Test03Board tb4 = new Test03Board(33,44);
		Test03Board tb5 = new Test03Board(33,"kim");
		Test03Board tb6 = new Test03Board("kim",33);
		
		
	}//end main()

}//end class
