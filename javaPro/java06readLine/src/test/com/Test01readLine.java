package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test01readLine {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("readLine....");
		
//		BufferedReader br = 
//				new BufferedReader(
//						new InputStreamReader(System.in));
		
		InputStream is = System.in;
		InputStreamReader isr = 
				new InputStreamReader(is);
		BufferedReader br = 
				new BufferedReader(isr);
		
		
		System.out.println("정수를 입력후 엔터...");
		String x = br.readLine();
		//int su = Integer.parseInt(x);
		//System.out.println(su);
		System.out.println(x);
		System.out.println("end main...");
	}//end main()

}//end class
