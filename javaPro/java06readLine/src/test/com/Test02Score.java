package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test02Score {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(System.in));
		
		System.out.println("����ó�����α׷�");
		System.out.println("�л����� �Է��ϼ���.");
		String sCount = br.readLine();
//		String sCount = "2";
		System.out.println("�л���:"+sCount);
		
		for (int i = 0; i < Integer.parseInt(sCount); i++) {
			
			System.out.println(">>"+(i+1)+"���л��� �̸��� �Է��ϼ���");
			String name = br.readLine();
			System.out.println(name);
			System.out.println("���������� �Է��ϼ���");
			int kor = Integer.parseInt(br.readLine());
			System.out.println(kor);
			System.out.println("���������� �Է��ϼ���");
			int eng = Integer.parseInt(br.readLine());;
			System.out.println(eng);
			System.out.println("���������� �Է��ϼ���");
			int math = Integer.parseInt(br.readLine());;
			System.out.println(math);
			
			int total = kor+eng+math;
			System.out.println("����:"+total);
			//��տ� ���������Ұ�.avg(double)
			double avg = total/3.0;
			System.out.println("���:"+avg);
			//��������� ��������
			//90���̻� A,
			//80���̻� B,
			//70���̻� C,
			//70���̸� "����"
			//ó���ϴ� ���α׷��� �߰��ϼ���
			//��޿� ���������Ұ�.grade(String)
			String grade = null;//null(�ּҰ��̾���)
			grade = avg>=90?"A":
					avg>=80?"B":
					avg>=70?"C":"����";
			System.out.println("���:["+grade+"]");
		}
		
		
		//1���л��� �̸��� �Է��ϼ���
		//ȫ�浿
		//���������� �Է��ϼ���
		//99
		//���������� �Է��ϼ���
		//98
		//���������� �Է��ϼ���
		//97
		//����:99+98+97=294
		//���:����/3=98
		//���:A
		
	}
}
