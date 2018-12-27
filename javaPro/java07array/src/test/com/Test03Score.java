package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test03Score {

	public static void main(String[] args) throws IOException {
		System.out.println("Score...");

		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(System.in));
		
		
		// 3명의 학생배열을 만들고
		// 각학생의 성적을 처리하는 프로그램을 완성하시오.
		// for문을 사용할것
		String[] names = new String[] {"홍길동1","홍길동2","홍길동3"};
		
		String datas = "";
		
		for (int i = 0; i < names.length; i++) {
			// 홍길동 국어점수를 입력하세요
			System.out.println(names[i]+" 국어점수를 입력하세요");
			// 99
			String kor = br.readLine();
			System.out.println(kor);

			// 홍길동 영어점수를 입력하세요
			System.out.println(names[i]+" 영어점수를 입력하세요");
			// 98
			String eng = br.readLine();
			System.out.println(eng);

			System.out.println(names[i]+" 수학점수를 입력하세요");
			// 97
			String math = br.readLine();
			System.out.println(math);

			// 홍길동 총점:99+98+97=294
			int total = Integer.parseInt(kor) + Integer.parseInt(eng) + Integer.parseInt(math);
			System.out.println(names[i]+" 총점:" + total);

			// 홍길동 평균:총점/3=98
			double avg = total / 3.0;
			System.out.println(names[i]+" 평균:" + avg);

			// 홍길동 등급:A
			String grade = "";
			if (avg >= 90) {
				grade = "A";
			} else if (avg >= 80) {
				grade = "B";
			} else if (avg >= 70) {
				grade = "C";
			} else {
				grade = "과락";
			}
			System.out.println(names[i]+" 등급:" + grade + "");
			
			datas += names[i]+" " + kor + " " + eng + " " + math + " " + total + " " + avg + " " + grade+"\n";
			
			System.out.println("===================");
		}//end for
		
		System.out.println(datas);

		// 최종 출력 예시===========
		// 홍길동1 99 88 77 274 88.0 B
		// 홍길동2 99 88 77 274 88.0 B
		// 홍길동3 99 88 77 274 88.0 B

	}// end main()

}// end class
