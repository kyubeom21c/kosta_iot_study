package test.com;

public class Test09breakContinue {

	public static void main(String[] args) {
		System.out.println("break...continue");

		for (int i = 0; i < 10; i++) {
			if (i % 2 != 0) {
				System.out.print(i);
			}
		}
		System.out.println();

		for (int i = 0; i < 10; i += 2) {
			System.out.print(i);
		}
		System.out.println();

		for (int i = 0; i < 10; i++) {
			System.out.print(i);
			if(i==4)break;
		}
		System.out.println();
		
		
		for (int i = 0; i < 10; i++) {
			if(i==5) {
				continue;
			}
			//if문블럭을 제외한 가장가까운블럭의 끝으로 가라
			System.out.print(i);
			System.out.print(i);
			System.out.print(i);
		}
		System.out.println();
		
		
		for (int i = 0; i < 10; i++) {
			if(i%2 == 0) {
				continue;
			}
			System.out.print(i);
		}
		System.out.println();
		
		for (int x = 0; x < 3; x++) {
			for (int i = 0; i < 10; i++) {
//				if(i==5)break;
				if(i==5)continue;
				System.out.print(x+":"+i+" ");
			}
			System.out.println();
		}
		

		aaa : for (int x = 0; x < 3; x++) {
			for (int i = 0; i < 10; i++) {
//				if(i==5)break aaa;
				if(i==5)continue aaa;
				System.out.print(x+":"+i+" ");
			}
			System.out.println();
		}
		
		

	}// end main()

}// end class
