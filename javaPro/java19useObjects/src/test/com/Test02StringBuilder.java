package test.com;

public class Test02StringBuilder {

	public static void main(String[] args) {
		System.out.println("StringBuffer...");
		System.out.println("StringBuilder...");
		
		//��뷮 ���ڿ�ó���� ����ϴ� ������Ʈ
		long startTime = System.currentTimeMillis();
//		StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000000; i++) {
			sb.append(String.valueOf(i));
		}
		//System.out.println(sb.toString());
		System.out.println(sb.length());
		
		System.out.println(System.currentTimeMillis()-startTime);
	}

}
