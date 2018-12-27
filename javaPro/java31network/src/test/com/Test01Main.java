package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test01Main {

	public static void main(String[] args) {
		System.out.println("java.net");
		HttpURLConnection conn = null;
		try {
			URL url = new URL("http://google.com");
//			URL url = new URL("http://192.168.0.191/IoTstudy187/DOC/fileReader.txt");
//			URL url = new URL("http://192.168.0.191/IoTstudy187/DOC/method01_dao.png");
			
			conn = (HttpURLConnection) url.openConnection();
			System.out.println(conn.getContentType());
			System.out.println(conn.getResponseCode()==200);
			System.out.println(conn.getContentLength());
			
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String str = null;
			while((str = br.readLine()) != null) {
				System.out.println(str);
				
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(conn != null)conn.disconnect();
		}
		
	}

}
