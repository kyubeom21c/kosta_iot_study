package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test01main {

	public static void main(String[] args) throws IOException {
		System.out.println("main....");
		InputStream is = System.in;
		InputStreamReader isr = 
				new InputStreamReader(is);
		BufferedReader br = 
				new BufferedReader(isr);

		// VO와 VO[] 을 사용하여 아래프로그램을 만드시오.
		Test01ScoreVO[] vos = new Test01ScoreVO[3];
		
		for (int i = 0; i < vos.length; i++) {
			System.out.println("이름을 입력하세요");
			String name = br.readLine();

			System.out.println("국어점수를 입력하세요");
			String kor = br.readLine();

			System.out.println("영어점수를 입력하세요");
			String eng = br.readLine();

			System.out.println("수학점수를 입력하세요");
			String math = br.readLine();
			
			Test01ScoreVO vo = new Test01ScoreVO(
					name, 
					Integer.parseInt(kor), 
					Integer.parseInt(eng), 
					Integer.parseInt(math));
			vos[i] = vo;
		}
		
		for (int i = 0; i < vos.length; i++) {
			//System.out.println(vos[i]);
			System.out.print(vos[i].name+" ");
			System.out.print(vos[i].kor+" ");
			System.out.print(vos[i].eng+" ");
			System.out.print(vos[i].math+" ");
			System.out.print(vos[i].total+" ");
			System.out.print(vos[i].avg+" ");
			System.out.println(vos[i].grade);
		}
		

		// 홍길동1 99 88 77 264 88.0 B
		// 홍길동2 99 88 77 264 88.0 B
		// 홍길동3 99 88 77 264 88.0 B

	}
}
