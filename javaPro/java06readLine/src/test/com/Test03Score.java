package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test03Score {
	public static void main(String[] args) throws IOException {
		System.out.println("����ó�����α׷� start");
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(System.in));
		//while���� ����Ͽ� �ݺ��ϴ� ���α׷����ϼ�.
		//�������� �����ʹ� input������ �����ÿ�.
		//�����x�� �Է¹޾Ƽ� ó���ϵ��� �Ͻÿ�.
		
		
//		System.out.println("1.����ó�� 2.�Խ���");
//		String menu = br.readLine();
//		if(menu.equals("1")) {
//			
//		}else {
//			
//		}
		
		String x = "";
		while(!x.equals("x")) {
			System.out.println("�̸��� �Է��ϼ���");
			String name = br.readLine();
			System.out.println(name);
			System.out.println("���������� �Է��ϼ���");
			int kor = Integer.parseInt(br.readLine());
			System.out.println(kor);
			System.out.println("���������� �Է��ϼ���");
			int eng = Integer.parseInt(br.readLine());
			System.out.println(eng);
			System.out.println("���������� �Է��ϼ���");
			int math = Integer.parseInt(br.readLine());
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
			//switch case break
			int key = (int)avg/10;
			System.out.println(">>>>"+key);
			switch (key) {
			case 10:
			case 9:
				grade = "A";
				break;
			case 8:
				grade = "B";
				break;
			case 7:
				grade = "C";
				break;

			default:
				grade = "����";
				break;
			}
			
			System.out.println("���:["+grade+"]");
			
			
			
			System.out.println("�����...x");
			x = br.readLine();
		}
		
		
		//�̸��� �Է��ϼ���
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
		System.out.println("����ó�����α׷� end");
	}//end main()
}//end class
