package test.com;

public class Test01Main {
	
	//2.�Ӽ�: �ʵ�,field, ��������
	int su=9;
	String name;
	double d;
	int[] sus;
	int[][] suss;
	
	//1.���: �޼ҵ� method,�Լ�,function>>����� ǥ��
	
	
	//3.������ : ����Ʈ����, constructor,��ü�������Ǻ�
	public Test01Main() {

		System.out.println("Test01Main()....");
	}
	
	
	//4.Ŭ���� : ����Ŭ����,��øŬ����
	
	
	//{},static{},@������̼�
	
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
