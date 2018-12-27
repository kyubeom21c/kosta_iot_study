package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test03MemberMain {

	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		InputStreamReader isr = 
				new InputStreamReader(is);
		BufferedReader br = 
				new BufferedReader(isr);
		
		
		System.out.println("member");

		Test03MemberVO[] vos = new Test03MemberVO[3];
		
		for (int i = 0; i < vos.length; i++) {
			System.out.print("id:");
			String id = br.readLine();
			System.out.print("pw:");
			String pw = br.readLine();
			System.out.print("name:");
			String name = br.readLine();
			System.out.print("tel:");
			String tel = br.readLine();
			
			Test03MemberVO vo = new Test03MemberVO(id, 
					pw, name, tel);
			vos[i] = vo;
			
		}//end for
		
		for (int i = 0; i < vos.length; i++) {
			//System.out.println(vo);
			System.out.print(i+1+" ");
			System.out.print(vos[i].id+" ");
			System.out.print(vos[i].pw+" ");
			System.out.print(vos[i].name+" ");
			System.out.println(vos[i].tel);
		}
		
		
		
		
		
	}

}
