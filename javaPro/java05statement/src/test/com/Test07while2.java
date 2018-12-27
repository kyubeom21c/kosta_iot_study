package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test07while2 {

	public static void main(String[] args) throws IOException {
		//반복문 while:동작,신호,상황이 올때까지 무한반복을 전제로..
		System.out.println("while");
		
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(System.in));
		
		String x = "";
		while (!x.equals("x")) {
			System.out.println("while...");
			System.out.println("그만?input x...");
			x = br.readLine();
		}

		System.out.println("end while..");
	}

}
