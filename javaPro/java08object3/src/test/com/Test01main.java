package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test01main {

	public static void main(String[] args) throws IOException {
		System.out.println("main....");
		InputStream is = System.in;
		InputStreamReader isr = 
				new InputStreamReader(is);
		BufferedReader br = 
				new BufferedReader(isr);

		// VO�� VO[] �� ����Ͽ� �Ʒ����α׷��� ����ÿ�.
		Test01ScoreVO[] vos = new Test01ScoreVO[3];
		
		for (int i = 0; i < vos.length; i++) {
			System.out.println("�̸��� �Է��ϼ���");
			String name = br.readLine();

			System.out.println("���������� �Է��ϼ���");
			String kor = br.readLine();

			System.out.println("���������� �Է��ϼ���");
			String eng = br.readLine();

			System.out.println("���������� �Է��ϼ���");
			String math = br.readLine();
			
			Test01ScoreVO vo = new Test01ScoreVO(
					name, 
					Integer.parseInt(kor), 
					Integer.parseInt(eng), 
					Integer.parseInt(math));
			vos[i] = vo;
		}
		
		for (int i = 0; i < vos.length; i++) {
			//System.out.println(vos[i]);
			System.out.print(vos[i].name+" ");
			System.out.print(vos[i].kor+" ");
			System.out.print(vos[i].eng+" ");
			System.out.print(vos[i].math+" ");
			System.out.print(vos[i].total+" ");
			System.out.print(vos[i].avg+" ");
			System.out.println(vos[i].grade);
		}
		

		// ȫ�浿1 99 88 77 264 88.0 B
		// ȫ�浿2 99 88 77 264 88.0 B
		// ȫ�浿3 99 88 77 264 88.0 B

	}
}
