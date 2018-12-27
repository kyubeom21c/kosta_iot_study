package test.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test01Main2 {

	public static void main(String[] args)  {
		System.out.println("java io");

		File f = new File("data.txt");
		System.out.println(f.exists());
		if(f.exists() && f.canRead()) {
			// 2. File input2
			FileReader fr = null;
			BufferedReader br = null;
			try {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				
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
				if(fr!=null) {
					try {
						fr.close();
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
