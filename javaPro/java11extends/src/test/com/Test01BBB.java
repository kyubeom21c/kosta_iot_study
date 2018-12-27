package test.com;

public class Test01BBB extends Test01CCC{

	int su;
	int su2;
	int su3;
	int su4;
	int su5;
	
	public Test01BBB() {
//		super();
		System.out.println("Test01BBB()....");
	}
	
	public int sum() {
		System.out.println(avg);
		super.ccc();
		this.ccc();
		return su+100;
	}
	
	//오버라이딩:super클래스의 메소드를 재정의 하는것
	//메소드명,반환타입,매개변수정의가 같아야한다.
	@Override
	public void ccc() {
		System.out.println("BBB ccc()");
		//super.ccc();
	}
	
}
