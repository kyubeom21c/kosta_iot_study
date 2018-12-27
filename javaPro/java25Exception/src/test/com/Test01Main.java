package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test01Main {

	public static void main(String[] args) {
		System.out.println("Exception...");
		
		//���α׷� �����Ͻ� �Ǵ� ����� �߻��Ǿ������ִ� 
		//����������
		//�̿��� ó���Ǵ� ���� ��Ű�� ��.
		
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String name = null;
		try {
			is = System.in;//a
			isr = new InputStreamReader(is);//b
			br = new BufferedReader(isr);//c
			
			name = br.readLine();//1.
			System.out.println(name);//2.
		} catch (IOException e1) {
			e1.printStackTrace();//3-1.
			name = "aaa";//3-2.
			System.out.println(name);//3-3.
		}finally {
			System.out.println("finally...");//4.
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(isr!=null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(isr!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}//end finally
		
		System.out.println("end main..." + name);//5.
	}//end main()
	

}
