package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test03Board {

	public static void main(String[] args) throws IOException {
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(System.in));
		
		
		
		
		for (int i = 0; i < 3; i++) {
			System.out.println("==================");
			System.out.println("\\게시\t판 \"프\"로그램");
			System.out.println("==================");
			
			String board = "[987]";
			
			System.out.println("글제\\name목을 입력하세요");
			String title = br.readLine();
			board += title;
			System.out.println(title);
			
			
			
			System.out.println("-------------------");
			System.out.println("글내용을 입력하세요");
			String content = br.readLine();
			board += content;
			System.out.println(content);
			
			System.out.println("-------------------");
			System.out.println("작성자를 입력하세요");
			String writer = br.readLine();
			board += writer;
			System.out.println(writer);
			
			System.out.println("-------------------");
			System.out.println("작성일자를 입력하세요");
			String wDate = br.readLine();
			board += wDate;
			System.out.println(wDate);
			System.out.println("-------------------");
			
			System.out.println(board);
		}
		
		
		//글제목을 입력하세요
		//자바 시간입니다.
		//글내용을 입력하세요
		//양샘이 자바를 잼나게 가르쳐주시네용.^^
		//작성자를 입력하세요
		//홍길동
		//작성일자를 입력하세요
		//2018.08.08
	}

}
