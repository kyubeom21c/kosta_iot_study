package test.com.ex02;

public class Test02this_super extends Test01Bus{
	int x;
	int y;
	int y2;
	int y3;
	int y4;
	int y5;
	public Test02this_super() {
//		super();//new Test01Bus()
		x = 10;
		y = 20;
		y2 = 20;
		y3 = 20;
		y4 = 20;
		y5 = 20;
	}
	public Test02this_super(int x) {
		this();
		this.x = x;
//		this.y = 20;
		
	}
	
	public Test02this_super(int y2,int y3) {
		this(33);
		this.y2 = y2;
		this.y3 = y3;
	}
	

	public static void main(String[] args) {
		System.out.println("this. this()  super. super()");

	}

}
