package test.com;

public class Test07while {

	public static void main(String[] args) {
		//반복문 while:동작,신호,상황이 올때까지 무한반복을 전제로..
		System.out.println("while");
		String x = "x";
		while (true) {
			System.out.println("x가아닌값을넣으면계속...");
			x = "x";
			if(x.equals("x")) {
				break;
			}
		}
		System.out.println("end while..");
	}

}
