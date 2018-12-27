package test.com;

public class Test03switch3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("switch");
		//key:정수,문자형,문자열
		String key = "Kim";
		switch (key) {
		case "kim":
			System.out.println("hello "+key);
			break;
		case "KIM":
			System.out.println("HELLO "+key);
			break;
		case "Kim":
			System.out.println("Hello "+key);
			break;

		default:
			break;
		}




		
		
	}

}
