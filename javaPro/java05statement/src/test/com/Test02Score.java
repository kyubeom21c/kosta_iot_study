package test.com;

public class Test02Score {
	public static void main(String[] args) {
		System.out.println("����ó�����α׷�");
		System.out.println("�̸��� �Է��ϼ���");
		String name = "kim";
		System.out.println(name);
		System.out.println("���������� �Է��ϼ���");
		int kor = 79;
		System.out.println(kor);
		System.out.println("���������� �Է��ϼ���");
		int eng = 79;
		System.out.println(eng);
		System.out.println("���������� �Է��ϼ���");
		int math = 79;
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
		if (avg>=90) {
			grade = "A";
		}else if (avg>=80) {
			grade = "B";
		}else if (avg>=70) {
			grade = "C";
		}else {
			grade = "����";
		}
		System.out.println("���:["+grade+"]");
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
		
	}
}
