package test.com;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test04DateFormat {

	public static void main(String[] args) {
		System.out.println("DateFormats");

		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());
		
		Timestamp ts = new Timestamp(date.getTime());
		System.out.println(ts.toString());
		
		//2018/08/20 14:28:24.632
		SimpleDateFormat sdf = 
				new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss.SSS");
		System.out.println(sdf.format(new Date()));
		
		//1,222,222 >>> NumberFormat..
		//System.out.println(Integer.parseInt("a"));
		
	}

}
