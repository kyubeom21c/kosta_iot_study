package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test03Score2 {

	public static void main(String[] args) throws IOException {
		System.out.println("Score...");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 3���� �л��迭�� �����
		// ���л��� ������ ó���ϴ� ���α׷��� �ϼ��Ͻÿ�.
		// for���� ����Ұ�
		String[] names = new String[] { "ȫ�浿1", "ȫ�浿2", "ȫ�浿3" };

		String[][] scores = new String[names.length][7];
		
		for (int x = 0; x < scores.length; x++) {
			// ȫ�浿 ���������� �Է��ϼ���
			System.out.println(names[x] + " ���������� �Է��ϼ���");
			// 99
//			String kor = br.readLine();
			String kor = "88";
			System.out.println(kor);

			// ȫ�浿 ���������� �Է��ϼ���
			System.out.println(names[x] + " ���������� �Է��ϼ���");
			// 98
//			String eng = br.readLine();
			String eng = "88";
			System.out.println(eng);

			System.out.println(names[x] + " ���������� �Է��ϼ���");
			// 97
//			String math = br.readLine();
			String math = "88";
			System.out.println(math);

			// ȫ�浿 ����:99+98+97=294
			int total = Integer.parseInt(kor) + Integer.parseInt(eng) + Integer.parseInt(math);
			System.out.println(names[x] + " ����:" + total);

			// ȫ�浿 ���:����/3=98
			double avg = total / 3.0;
			System.out.println(names[x] + " ���:" + avg);

			// ȫ�浿 ���:A
			String grade = "";
			if (avg >= 90) {
				grade = "A";
			} else if (avg >= 80) {
				grade = "B";
			} else if (avg >= 70) {
				grade = "C";
			} else {
				grade = "����";
			}
			System.out.println(names[x] + " ���:" + grade + "");
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

		// ���� ��� ����===========
		// ȫ�浿1 99 88 77 274 88.0 B
		// ȫ�浿2 99 88 77 274 88.0 B
		// ȫ�浿3 99 88 77 274 88.0 B

	}// end main()

}// end class
