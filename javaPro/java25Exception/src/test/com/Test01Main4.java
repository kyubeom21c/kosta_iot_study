package test.com;

public class Test01Main4 {

	public static void main(String[] args) {
		System.out.println("Exception...");
		
		//���α׷� �����Ͻ� �Ǵ� ����� �߻��Ǿ������ִ� 
		//����������
		//�̿��� ó���Ǵ� ���� ��Ű�� ��.
		TestDAO2 dao = null;
		try {
			dao = new TestDAO2();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			dao.testNull();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		try {
			dao.testNumber();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		try {
			dao.testArray();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		System.out.println("end main..." );

	}//end main()
	

}
