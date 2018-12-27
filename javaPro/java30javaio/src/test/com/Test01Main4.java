package test.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Test01Main4 {

	public static void main(String[] args) {
		System.out.println("java io");

		File f = new File("data.txt");
		System.out.println(f.exists());
		System.out.println(f.canWrite());
		if (f.exists() && f.canWrite()) {
			// 3. File output
			FileWriter fw = null;
			try {
				fw = new FileWriter(f,true);
				String str = "1:xxx:33:44:55\n";
				fw.write(str);
				fw.write(str);
				fw.write(str);
				fw.write(str);
				fw.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fw != null) {
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		System.out.println("end main()");
	}

}
