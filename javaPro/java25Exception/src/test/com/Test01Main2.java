package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test01Main2 {

	public static void main(String[] args) {
		System.out.println("Exception...");
		
		//���α׷� �����Ͻ� �Ǵ� ����� �߻��Ǿ������ִ� 
		//����������
		//�̿��� ó���Ǵ� ���� ��Ű�� ��.
		
		String name = null;
		
		
		try {
			name = "aaa";
			System.out.println(name.length());//1
			System.out.println(name);//2
			//args[2] = "kim";
			Integer.parseInt(name);
		} catch (NullPointerException e) {
			e.printStackTrace();
			name = "bbb";
			System.out.println(name);//3
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			name = "ccc";
			System.out.println(name);//4
		} catch (NumberFormatException e) {
			e.printStackTrace();
			name = "ddd";
			System.out.println(name);//5
		}catch (Exception e) {
			e.printStackTrace();
			name = "eee";
			System.out.println(name);//5
		}
		
		System.out.println("end main..." );

	}//end main()
	

}
