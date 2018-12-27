package test.com;

public class Test01Method {

	
	//{}, ;
	
	//1.인자값없고 반환값도 없고
	public void aaa() {
		System.out.println("aaa()");
		//return ; 반환타입이 void선언시 생략가능
	}
	
	//2.인자값없고 반환값도 있고
	public int aaa2() {
		System.out.println("aaa2()");
		return 100; 
	}
	
	//3.인자값있고 반환값도 없고
	public void aaa3(int x,int y) {
		System.out.println("aaa3("+(x+y)+")");
	}
	
	//4.인자값있고 반환값도 있고
	public String[] aaa4(String name) {
		System.out.println("aaa4("+name+")");
		return new String[]{"hello","hi"}; 
	}
	
}
