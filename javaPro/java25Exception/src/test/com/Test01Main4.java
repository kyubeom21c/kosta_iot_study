package test.com;

public class Test01Main4 {

	public static void main(String[] args) {
		System.out.println("Exception...");
		
		//프로그램 컴파일시 또는 실행시 발생되어질수있는 
		//오류에대해
		//미연에 처리또는 전가 시키는 것.
		TestDAO2 dao = null;
		try {
			dao = new TestDAO2();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			dao.testNull();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		try {
			dao.testNumber();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		try {
			dao.testArray();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		System.out.println("end main..." );

	}//end main()
	

}
