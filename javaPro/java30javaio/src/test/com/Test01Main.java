package test.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test01Main {

	public static void main(String[] args)  {
		System.out.println("java io");
//		json : JavaScript Object Notation
//		[item,item,item] : array
//		{"key":value, "key":value} : object
		
//		XML : Extensible Markup Language
		//<element attribute="value">body<element/>
		//<element/>no body
		
		// 1.System input
//		InputStream is = null;
//		InputStreamReader isr = null;
//		BufferedReader br = null;
//		is = System.in;
//		isr = new InputStreamReader(is);
//		br = new BufferedReader(isr);
//		br.close();
//		isr.close();
//		is.close();
		
		File f = new File("data.txt");
		System.out.println(f.exists());
		System.out.println(f.canRead());
		
		if(f.exists() && f.canRead()) {
			// 2. File input
			FileInputStream fis = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			try {
				fis = new FileInputStream(f);
				isr = new InputStreamReader(fis);
				br = new BufferedReader(isr);
				
				String str = null;
				StringBuilder sb = new StringBuilder();
				while((str = br.readLine()) != null) {
					sb.append(str+"\n");
				}
				System.out.println(sb.toString());
//				1:aaa1:99:88:77
//				2:aaa2:99:88:77
//				3:aaa3:99:88:77
//				4:aaa4:99:88:77
//				5:aaa5:99:88:77
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
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
				if(fis!=null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}//end finally
		}
		
		
		

		// 3. File output
		
		
		System.out.println("end main()");
	}

}
