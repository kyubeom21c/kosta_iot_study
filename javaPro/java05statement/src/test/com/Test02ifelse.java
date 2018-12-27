package test.com;

public class Test02ifelse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("if else");
		
		//조건에 대한 분기처리
		if (5!=5) {
			System.out.println("if");
		} 
		else {
			System.out.println("else");
		}
		
		int su = -7;
		if (su==10) {
			System.out.println("a");
		}else if (su==9) {
			System.out.println("b");
		}else if (su==8) {
			System.out.println("c");
		}else if (su==7) {
			System.out.println("d");
		}else if (su==6) {
			System.out.println("e");
		}else {
			System.out.println("else");
		}
		
		char c = 'c';
		String grade = null;
		if (c=='a') {
			grade = "A";
		}else if (c=='b') {
			grade = "B";
		}else if (c=='c') {
			grade = "C";
		}else if (c=='d') {
			grade = "D";
		}else if (c=='e') {
			grade = "E";
		}else {
			System.out.println("else");
		}
		System.out.println(grade);
	}

}
