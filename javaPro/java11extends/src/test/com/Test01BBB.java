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
	
	//�������̵�:superŬ������ �޼ҵ带 ������ �ϴ°�
	//�޼ҵ��,��ȯŸ��,�Ű��������ǰ� ���ƾ��Ѵ�.
	@Override
	public void ccc() {
		System.out.println("BBB ccc()");
		//super.ccc();
	}
	
}
