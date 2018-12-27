package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class KostaMain {

	public static void main(String[] args) {
		// http://localhost:8090/web04json/json_selectOne2.do?num=2
		// http://localhost:8090/web04json/json_selectAll3.do
		// Data parsing
		System.out.println("Kosta main....");
		
		try {
			URL url = new URL("http://192.168.0.191:8090/web04json/json_selectAll3.do");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			if(con.getResponseCode()==200) {
				System.out.println("200...");
				
				InputStream is = con.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String str = "";
				StringBuilder sb = new StringBuilder();
				while((str = br.readLine())!=null) {
					sb.append(str);
				}
				System.out.println(sb.toString());
				
				JSONArray array = new JSONArray(sb.toString());
				for (int i = 0; i < array.length(); i++) {
					JSONObject obj = array.getJSONObject(i);
					System.out.print(obj.getInt("num")+" ");
					System.out.print(obj.getString("id")+" ");
					System.out.print(obj.getString("pw")+" ");
					System.out.print(obj.getString("name")+" ");
					System.out.println(obj.getString("tel"));
				}
			}else {
				System.out.println("fail....");
			}
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
