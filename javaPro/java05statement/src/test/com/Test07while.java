package test.com;

public class Test07while {

	public static void main(String[] args) {
		//�ݺ��� while:����,��ȣ,��Ȳ�� �ö����� ���ѹݺ��� ������..
		System.out.println("while");
		String x = "x";
		while (true) {
			System.out.println("x���ƴѰ�����������...");
			x = "x";
			if(x.equals("x")) {
				break;
			}
		}
		System.out.println("end while..");
	}

}
