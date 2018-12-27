package test.com;

public class Test05forfor {

	public static void main(String[] args) {
		
		System.out.println("for for");
		
//		0123456789
//		0123456789
//		0123456789
		
//		0123456789
//		0123456789
//		0123456789
		
//		0123456789
//		0123456789
//		0123456789
		
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
		}
		System.out.println();
		
		for (int x = 0; x < 3; x++) {
			for (int i = 0; i < 10; i++) {
				System.out.print(i);
			}
			System.out.println();
		}
		

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				for (int i = 0; i < 10; i++) {
					System.out.print(i);
				}
				System.out.println();
			}
			System.out.println();
		}

		
	}//end main()

}//end class
