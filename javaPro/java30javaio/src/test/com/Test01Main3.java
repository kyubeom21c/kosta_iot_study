package test.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01Main3 {

	public static void main(String[] args) {
		System.out.println("java io");

		File f = new File("data.txt");
		System.out.println(f.exists());
		System.out.println(f.canWrite());
		if (f.exists() && f.canWrite()) {
			// 3. File output
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(f,true);
				String str = "1:xxx:33:44:55\n";
				fos.write(str.getBytes());
				fos.write(str.getBytes());
				fos.write(str.getBytes());
				fos.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		System.out.println("end main()");
	}

}
