package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test03Score2 {

	public static void main(String[] args) throws IOException {
		System.out.println("Score...");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 3명의 학생배열을 만들고
		// 각학생의 성적을 처리하는 프로그램을 완성하시오.
		// for문을 사용할것
		String[] names = new String[] { "홍길동1", "홍길동2", "홍길동3" };

		String[][] scores = new String[names.length][7];
		
		for (int x = 0; x < scores.length; x++) {
			// 홍길동 국어점수를 입력하세요
			System.out.println(names[x] + " 국어점수를 입력하세요");
			// 99
//			String kor = br.readLine();
			String kor = "88";
			System.out.println(kor);

			// 홍길동 영어점수를 입력하세요
			System.out.println(names[x] + " 영어점수를 입력하세요");
			// 98
//			String eng = br.readLine();
			String eng = "88";
			System.out.println(eng);

			System.out.println(names[x] + " 수학점수를 입력하세요");
			// 97
//			String math = br.readLine();
			String math = "88";
			System.out.println(math);

			// 홍길동 총점:99+98+97=294
			int total = Integer.parseInt(kor) + Integer.parseInt(eng) + Integer.parseInt(math);
			System.out.println(names[x] + " 총점:" + total);

			// 홍길동 평균:총점/3=98
			double avg = total / 3.0;
			System.out.println(names[x] + " 평균:" + avg);

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
			System.out.println(names[x] + " 등급:" + grade + "");
			//String[] score = new String[] { names[x], kor, eng, math, total + "", avg + "", grade };
			String[] score = new String[7];
			System.out.println("score:"+score);
			score[0] = names[x];
			score[1] = kor;
			score[2] = eng;
			score[3] = math;
			score[4] = total+"";
			score[5] = avg+"";
			score[6] = grade;
			scores[x] = score;
		}
		System.out.println("===================");
		for (int x = 0; x < scores.length; x++) {
			for (int i = 0; i < scores[x].length; i++) {
				System.out.print(scores[x][i] + " ");
			}
			System.out.println();
		}

		System.out.println("===================");

		// 최종 출력 예시===========
		// 홍길동1 99 88 77 274 88.0 B
		// 홍길동2 99 88 77 274 88.0 B
		// 홍길동3 99 88 77 274 88.0 B

	}// end main()

}// end class
