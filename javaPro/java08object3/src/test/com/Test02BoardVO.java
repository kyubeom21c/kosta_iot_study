package test.com;

import java.util.Date;

public class Test02BoardVO {
	int num;
	String title;
	String content;
	String writer;
	Date wDate;
	
	public Test02BoardVO(int num,String title, 
			String content, String writer) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.wDate = new Date();
	}

	public Test02BoardVO() {
		// TODO Auto-generated constructor stub
	}

}
