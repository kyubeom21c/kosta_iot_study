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
		
		
		// 3���� �л��迭�� �����
		// ���л��� ������ ó���ϴ� ���α׷��� �ϼ��Ͻÿ�.
		// for���� ����Ұ�
		String[] names = new String[] {"ȫ�浿1","ȫ�浿2","ȫ�浿3"};
		
		String datas = "";
		
		for (int i = 0; i < names.length; i++) {
			// ȫ�浿 ���������� �Է��ϼ���
			System.out.println(names[i]+" ���������� �Է��ϼ���");
			// 99
			String kor = br.readLine();
			System.out.println(kor);

			// ȫ�浿 ���������� �Է��ϼ���
			System.out.println(names[i]+" ���������� �Է��ϼ���");
			// 98
			String eng = br.readLine();
			System.out.println(eng);

			System.out.println(names[i]+" ���������� �Է��ϼ���");
			// 97
			String math = br.readLine();
			System.out.println(math);

			// ȫ�浿 ����:99+98+97=294
			int total = Integer.parseInt(kor) + Integer.parseInt(eng) + Integer.parseInt(math);
			System.out.println(names[i]+" ����:" + total);

			// ȫ�浿 ���:����/3=98
			double avg = total / 3.0;
			System.out.println(names[i]+" ���:" + avg);

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
			System.out.println(names[i]+" ���:" + grade + "");
			
			datas += names[i]+" " + kor + " " + eng + " " + math + " " + total + " " + avg + " " + grade+"\n";
			
			System.out.println("===================");
		}//end for
		
		System.out.println(datas);

		// ���� ��� ����===========
		// ȫ�浿1 99 88 77 274 88.0 B
		// ȫ�浿2 99 88 77 274 88.0 B
		// ȫ�浿3 99 88 77 274 88.0 B

	}// end main()

}// end class
