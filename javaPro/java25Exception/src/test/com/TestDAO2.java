package test.com;

public class TestDAO2 {

	public TestDAO2() throws ClassNotFoundException {
		System.out.println("TestDAO()...");
		Class.forName("test.com.Test01Main");
	}

	public void testNull() throws NullPointerException {
		System.out.println("testNull()....");
		Test01Main tm = null;
		System.out.println(tm.equals("aa"));
	}

	public void testNumber() throws NumberFormatException {
		System.out.println("testNumber()....");
		double d = Double.parseDouble("3.14ff");
	}

	public void testArray() throws ArrayIndexOutOfBoundsException {
		System.out.println("testArray()....");
		int[] sus = new int[3];
		sus[3] = 0;
	}

}
