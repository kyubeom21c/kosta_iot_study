package test.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Test02FileReaderMain {

	public static void main(String[] args) {
		System.out.println("FileReader");
		
		Test02FileReaderDAO dao = new Test02FileReaderDAOimpl();
		
		File f = new File("fileReader.txt");
		System.out.println(f.exists());
		if(f.exists() && f.canRead()) {
			// 2. File input2
			FileReader fr = null;
			BufferedReader br = null;
			try {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				
				String str = null;
				
				while((str = br.readLine()) != null) {
					String[] row = str.split(":");
					
					Test02FileReaderVO vo = new Test02FileReaderVO();
					vo.setNum(Integer.parseInt(row[0]));
					vo.setName(row[1]);
					vo.setKor(Integer.parseInt(row[2]));
					vo.setEng(Integer.parseInt(row[3]));
					vo.setMath(Integer.parseInt(row[4]));
					
					int result = dao.insert(vo);
					System.out.println("result:"+result);
				}
				
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
		
		List<Test02FileReaderVO> vos = dao.selectAll();
		for (Test02FileReaderVO x : vos) {
			System.out.print(x.getNum()+" ");
			System.out.print(x.getName()+" ");
			System.out.print(x.getKor()+" ");
			System.out.print(x.getEng()+" ");
			System.out.println(x.getMath());
		}
		
	}

}
