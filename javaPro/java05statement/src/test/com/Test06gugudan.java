package test.com;

public class Test06gugudan {

	public static void main(String[] args) {
		
		System.out.println("for for");

		//2*1=2 2*2=3...2*9=18
		//3*1=3 3*2=6...3*9=27
		//..
		//9*1=9 9*2=18...9*9=81
		
		
		for (int x = 2; x < 10; x++) {
			for (int i = 1; i < 10; i++) {
				System.out.print(x+"*"+i+"="+x*i+" ");
			}
			System.out.println();
		}
		

		
	}//end main()

}//end class
