package test.com;

public class TestDAO {

	public TestDAO() {
		System.out.println("TestDAO()...");
		try {
			Class.forName("test.com.Test01Main");
			System.out.println("find successed");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testNull() {
		System.out.println("testNull()....");
		try {
			Test01Main tm = null;
			System.out.println(tm.equals("aa"));
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testNumber() {
		System.out.println("testNumber()....");
		try {
			double d = Double.parseDouble("3.14ff");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testArray() {
		System.out.println("testArray()....");
		try {
			int[] sus = new int[3];
			System.out.println(sus[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
