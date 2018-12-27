package test.com;

public class Test01Type {

	//field
	public static void main(String[] args) {
		//local 
		System.out.println("type & variable");
		
		//타입:유형,그릇>> 데이터를 담는 곳
		byte su;//1byte>>8bit>>-128~127  0000 0000
		//System.out.println(su);
		su = (byte)129;
		System.out.println(su);
		System.out.println(Byte.MIN_VALUE+"~"+Byte.MAX_VALUE);
		
		
		short su2 = 10;//2byte>> 16bit>>0000 0000 0000 0000
		su2 = (short)-33000;
		System.out.println(su2);
		System.out.println(Short.MIN_VALUE+"~"+Short.MAX_VALUE);
		
		char su3 = 10;//2byte>>양의정수,한글자(문자형) 'a','김'
		char su33 = 'A';
		System.out.println(Character.MIN_VALUE+"~"+Character.MAX_VALUE);
		System.out.println((int)Character.MIN_VALUE+"~"+(int)Character.MAX_VALUE);
		System.out.println(su33);
		System.out.println((int)su33);
		
		int su4 = 10;//default //4byte>>약-21억~21억
		System.out.println(Integer.MIN_VALUE+"~"+Integer.MAX_VALUE);
		String str = "1000";
		int strsu = Integer.parseInt(str);
		System.out.println(str+2000);
		
		
		
		long su5 = 10L;//8byte>>-900경~900경
		System.out.println(Long.MIN_VALUE+"~"+Long.MAX_VALUE);
		
		double d1 = 3.14;//default//8byte
		System.out.println(Double.MIN_VALUE+"~"+Double.MAX_VALUE);
		float d2 = 3.14f;//4byte
		System.out.println(Float.MIN_VALUE+"~"+Float.MAX_VALUE);
		System.out.println(Double.parseDouble("333.333")+22);
		
		boolean b = false;//true 0,1
		System.out.println(b);
		System.out.println(Boolean.TRUE+" or "+Boolean.FALSE);
		System.out.println(Boolean.parseBoolean("true"));
		
		//글자(문자열)를 담는 타입>> String
		String name = "";
		//CharSequence cs = "bbbbbbbbbbb";
	}

}
