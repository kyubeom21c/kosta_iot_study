package test.com;

public class Test01array {

	public static void main(String[] args) {
		
		System.out.println("array....");
		
		//1.변수
		int kor = 10;
		String name = "kim";
		
		
		int a0=0,a1=0,a2=0;
		
		//메모리에 주소가 할당이되고 할당된 길이만큼의
		//각 index(position)에 데이터를 담는다.
		//int[] sus = {1,2,3};
		int[] sus = new int[]{11,12,13,44,44,44,44,44};
		System.out.println(sus);
//		System.out.println(sus[0]);
//		System.out.println(sus[1]);
//		System.out.println(sus[2]);
//		System.out.println(sus[3]);
		System.out.println("sus.length:"+sus.length);
		
		for (int i = 0; i < sus.length; i++) {
			System.out.println(sus[i]);
		}
		
		int[] sus2 = new int[3];//{0,0,0}<<{1,2,3}
		System.out.println("sus2.length:"+sus2.length);
		for (int i = 0; i < sus2.length; i++) {
			System.out.println(sus2[i]);
		}
		
		for (int i = 0; i < sus2.length; i++) {
//			sus2[i] = i+1;
			sus2[i] = (i+1)*10;
		}
//		sus2[0] = 1;
//		sus2[1] = 2;
//		sus2[2] = 3;
//		
		
		
		for (int i = 0; i < sus2.length; i++) {
			System.out.println(sus2[i]);
		}
		
	}

}
