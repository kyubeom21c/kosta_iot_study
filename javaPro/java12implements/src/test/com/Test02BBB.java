package test.com;

public class Test02BBB implements Test02AAA {

	int kor;
	double avg;
	@Override
	public int test(String x) {
		System.out.println("test..."+x);
		aaa();
		return 0;
	}
	public void aaa() {
		System.out.println("aaa()..");
	}

}
