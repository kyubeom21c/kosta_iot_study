package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test02BoardMain {

	public static void main(String[] args) throws IOException {
		System.out.println("board...");
		InputStream is = System.in;
		InputStreamReader isr = 
				new InputStreamReader(is);
		BufferedReader br = 
				new BufferedReader(isr);
		System.out.println("==================");
		System.out.println("�Խ��� ���α׷�");
		System.out.println("==================");
		
		Test02BoardVO[] vos = new Test02BoardVO[3];
		
		for (int i = 0; i < vos.length; i++) {
			System.out.println("�������� �Է��ϼ���");
			String title = br.readLine();
//			String title = "web �ð��Դϴ�.";
			//System.out.println(title);

			System.out.println("-------------------");
			System.out.println("�۳����� �Է��ϼ���");
//			String content = "kim���� �ڹٸ� �볪�� �������ֽó׿�.^^";
			String content = br.readLine();
			//System.out.println(content);

			System.out.println("-------------------");
			System.out.println("�ۼ��ڸ� �Է��ϼ���");
			String writer = br.readLine();
//			String writer = "ȫ�浿2";
			//System.out.println(writer);

			System.out.println("-------------------");

			Test02BoardVO vo = new Test02BoardVO(i+1, title, content, writer);
			//System.out.println(vo);
			vos[i] = vo;
			
			
		}//end for
		
		for (int i = 0; i < vos.length; i++) {
			System.out.println("-------------------");
			System.out.println(vos[i].num);
			System.out.println(vos[i].title);
			System.out.println(vos[i].content);
			System.out.println(vos[i].writer);
			System.out.println(vos[i].wDate);
			System.out.println("-------------------");
		}

		// VO�� VO[] �� ����Ͽ� �Ʒ����α׷��� ����ÿ�.
		// �������� �Է��ϼ���
		// �ڹ� �ð��Դϴ�.
		// �۳����� �Է��ϼ���
		// ����� �ڹٸ� �볪�� �������ֽó׿�.^^
		// �ۼ��ڸ� �Է��ϼ���
		// ȫ�浿

		// num title content writer wDate
		// 1 aaa bbb kim 2018~~~~
		// 2 aaa bbb lee 2018~~~~
		// 3 aaa bbb han 2018~~~~
	}

}
