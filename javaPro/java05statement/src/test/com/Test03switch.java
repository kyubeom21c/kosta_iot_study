package test.com;

public class Test03switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("switch");
		//key:����,������,���ڿ�
		int key = 10;
		switch (key) {
		case 10:
			System.out.println(100*key);
			if (100*key>500) {
				break;//if���� ������ ���尡������ ����������
			}
			System.out.println("aaaaa");
		case 9:
			System.out.println(90*key);
			break;
			
		case 8:
			System.out.println(80*key);
			break;

		default:
			System.out.println(0*key);
			break;
		}
		
		
	}

}
