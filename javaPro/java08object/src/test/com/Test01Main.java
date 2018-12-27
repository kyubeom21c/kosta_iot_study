package test.com;

public class Test01Main {
	
	//2.속성: 필드,field, 전역변수
	int su=9;
	String name;
	double d;
	int[] sus;
	int[][] suss;
	
	//1.기능: 메소드 method,함수,function>>동사로 표현
	
	
	//3.생성자 : 컨스트럭터, constructor,객체생성정의부
	public Test01Main() {

		System.out.println("Test01Main()....");
	}
	
	
	//4.클래스 : 내부클래스,중첩클래스
	
	
	//{},static{},@어노테이션
	
	public static void main(String[] args) {
		System.out.println("object");
		
		//int a,b,c....;
		//int[] sus
		//int[][] suss = new int[][];
		
		Test01Main tm = new Test01Main();
		System.out.println(tm);
		System.out.println(tm.su);
		System.out.println(tm.sus);
		System.out.println(tm.suss);
		System.out.println(tm.d);
		System.out.println(tm.name);
		
	}//end main()

}//end class
