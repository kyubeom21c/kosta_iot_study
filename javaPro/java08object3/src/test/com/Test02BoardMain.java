package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test02BoardMain {

	public static void main(String[] args) throws IOException {
		System.out.println("board...");
		InputStream is = System.in;
		InputStreamReader isr = 
				new InputStreamReader(is);
		BufferedReader br = 
				new BufferedReader(isr);
		System.out.println("==================");
		System.out.println("게시판 프로그램");
		System.out.println("==================");
		
		Test02BoardVO[] vos = new Test02BoardVO[3];
		
		for (int i = 0; i < vos.length; i++) {
			System.out.println("글제목을 입력하세요");
			String title = br.readLine();
//			String title = "web 시간입니다.";
			//System.out.println(title);

			System.out.println("-------------------");
			System.out.println("글내용을 입력하세요");
//			String content = "kim샘이 자바를 잼나게 가르쳐주시네용.^^";
			String content = br.readLine();
			//System.out.println(content);

			System.out.println("-------------------");
			System.out.println("작성자를 입력하세요");
			String writer = br.readLine();
//			String writer = "홍길동2";
			//System.out.println(writer);

			System.out.println("-------------------");

			Test02BoardVO vo = new Test02BoardVO(i+1, title, content, writer);
			//System.out.println(vo);
			vos[i] = vo;
			
			
		}//end for
		
		for (int i = 0; i < vos.length; i++) {
			System.out.println("-------------------");
			System.out.println(vos[i].num);
			System.out.println(vos[i].title);
			System.out.println(vos[i].content);
			System.out.println(vos[i].writer);
			System.out.println(vos[i].wDate);
			System.out.println("-------------------");
		}

		// VO와 VO[] 을 사용하여 아래프로그램을 만드시오.
		// 글제목을 입력하세요
		// 자바 시간입니다.
		// 글내용을 입력하세요
		// 양샘이 자바를 잼나게 가르쳐주시네용.^^
		// 작성자를 입력하세요
		// 홍길동

		// num title content writer wDate
		// 1 aaa bbb kim 2018~~~~
		// 2 aaa bbb lee 2018~~~~
		// 3 aaa bbb han 2018~~~~
	}

}
