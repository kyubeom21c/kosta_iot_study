package test.com;

import java.util.StringTokenizer;


public class Test01String {

	public static void main(String[] args) {
		System.out.println("String....");

		String str = "����ȭ ���� �Ǿ����ϴ�.";
		// ���ڿ��� ���̰�
		System.out.println("str.length():" + str.length());

		// ���ڿ����� �ѱ��� �̱�
		char c = str.charAt(1);
		System.out.println(c);

		// �������� ���� ���� �ɽ���(����ȯ)
		System.out.println((int) c);

		// ���ڿ��� ���� ��
		System.out.println(str.equals("abc"));
		
		str = "abc";
		// ���ڿ��� ���� ��
		System.out.println(str.compareTo("abc")==0);
		
		// ���ڿ��� ���� ��
		System.out.println(str.equalsIgnoreCase("Abc"));
		
		str = "abcdefghijk";
		System.out.println(str.substring(5));
		int beginIndex = 3;
		int endIndex = beginIndex+3;

		str = "alfau[pihejioufhaj;f";
		int bIndex = str.indexOf("f");
		int eIndex = str.indexOf(";");
		System.out.println(bIndex);
		System.out.println(str.substring(bIndex, eIndex));
		
		System.out.println(str.lastIndexOf("f"));
		
		
		str = "aabbccdd";
		str = str.replace('a', 't');
		System.out.println(str);
		str = str.replace("bb", "mm");
		System.out.println(str);
		
		String a = "aaa";
		String b = "bbb";
		String sum = a + b;
		System.out.println(sum);
		
		String sum2 = a.concat(b);
		System.out.println(sum2);
		
		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
		String temp = "";
//		for (int i = 0; i < 100000; i++) {
//			temp += i;
//		}
//		for (int i = 0; i < 100000; i++) {
//			temp = temp.concat(String.valueOf(i));
//		}
		System.out.println(System.currentTimeMillis()-startTime);
		
		String temp2 = "aaa:777:333:xxxxxx";
		String[] datas = temp2.split(":");
		for (int i = 0; i < datas.length; i++) {
			System.out.println(datas[i]);
		}
		
		//StringTokenizer
		temp2 = "aaa|777|333|xxxxxx";
		StringTokenizer st = 
				new StringTokenizer(temp2, "|");
		while (st.hasMoreElements()) {
			String x = (String) st.nextElement();
			System.out.println(x);
		}
	}// end main()

}
