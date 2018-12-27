package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test01Main3 {

	public static void main(String[] args) {
		System.out.println("Exception...");
		
		//프로그램 컴파일시 또는 실행시 발생되어질수있는 
		//오류에대해
		//미연에 처리또는 전가 시키는 것.
		
		TestDAO dao = new TestDAO();
		
		dao.testNull();
		
		dao.testNumber();
		
		dao.testArray();

		
		System.out.println("end main..." );

	}//end main()
	

}
