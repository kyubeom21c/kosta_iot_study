package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test06gugudan {

	public static void main(String[] args) throws IOException {
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(System.in));
		System.out.println("for for");

		//2*1=2 2*2=3...2*9=18
		//3*1=3 3*2=6...3*9=27
		//..
		//9*1=9 9*2=18...9*9=81
		System.out.println("시작단을 입력하세요");
		String startDan = br.readLine();
		System.out.println(startDan);
		System.out.println("끝단을 입력하세요");
		String endDan = br.readLine();
		System.out.println(endDan);
		
		for (int x = Integer.parseInt(startDan); x < Integer.parseInt(endDan)+1; x++) {
			for (int i = 1; i < 10; i++) {
				System.out.print(x+"*"+i+"="+x*i+" ");
			}
			System.out.println();
		}
		

		
	}//end main()

}//end class
