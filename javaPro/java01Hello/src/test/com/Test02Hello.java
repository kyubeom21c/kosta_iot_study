package test.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test02Hello {
	
	
	
	//main ctrl+space
	public static void main(String[] args) {
		System.out.println("hello");
		//ctrl alt 화살표 >>>복사+붙
		//ctrl +shift +l
		
		File f = new File("data.txt");
		System.out.println(f.exists());
		System.out.println(f.canWrite());
		System.out.println(f.canRead());
		
		try {
			FileOutputStream fos = new FileOutputStream(f,true);
			fos.write("test".getBytes());
			fos.flush();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileWriter fw = new FileWriter(f,true);
			fw.write("java");
			fw.flush();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String str = null;
			StringBuilder sb = new StringBuilder();
			List<String> list = new ArrayList<>();
			while((str = br.readLine())!= null) {
				System.out.println(str);
				list.add(str);
				sb.append(str+"\n");
			}
			System.out.println();
			System.out.println(sb);
			System.out.println();
			for (String x : list) {
				System.out.println(x);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			FileInputStream fis = new FileInputStream(f);
//			InputStreamReader isr = new InputStreamReader(fis);
//			BufferedReader br = new BufferedReader(isr);
//			String str = null;
//			StringBuilder sb = new StringBuilder();
//			List<String> list = new ArrayList<>();
//			while((str = br.readLine())!= null) {
//				System.out.println(str);
//				list.add(str);
//				sb.append(str+"\n");
//			}
//			System.out.println();
//			System.out.println(sb);
//			System.out.println();
//			for (String x : list) {
//				System.out.println(x);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
