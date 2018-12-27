package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test01Main2 {

	public static void main(String[] args) {
		System.out.println("Exception...");
		
		//프로그램 컴파일시 또는 실행시 발생되어질수있는 
		//오류에대해
		//미연에 처리또는 전가 시키는 것.
		
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
