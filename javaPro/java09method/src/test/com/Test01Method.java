package test.com;

public class Test01Method {

	
	//{}, ;
	
	//1.���ڰ����� ��ȯ���� ����
	public void aaa() {
		System.out.println("aaa()");
		//return ; ��ȯŸ���� void����� ��������
	}
	
	//2.���ڰ����� ��ȯ���� �ְ�
	public int aaa2() {
		System.out.println("aaa2()");
		return 100; 
	}
	
	//3.���ڰ��ְ� ��ȯ���� ����
	public void aaa3(int x,int y) {
		System.out.println("aaa3("+(x+y)+")");
	}
	
	//4.���ڰ��ְ� ��ȯ���� �ְ�
	public String[] aaa4(String name) {
		System.out.println("aaa4("+name+")");
		return new String[]{"hello","hi"}; 
	}
	
}
