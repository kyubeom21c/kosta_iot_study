package test.com;

import java.util.Arrays;

public class RandomMain {

	public static void main(String[] args) {
		System.out.println("Random");
		
//		int[] sus = new int[] {3,2,1,4,5,6};
//		Arrays.sort(sus);
//		for (int x : sus) {
//			System.out.println(x);
//		}
		
		String[] names = new String[] {
				"��¹�","������","������","������",
				"���Ҷ�","��μ�","�ǿ���","������",
				"������","�輺��","�ڽ���","������",
				"������","Ȳ����","�ֱԹ�","������"
		};
		System.out.println("names.length:"+names.length);
		
		RandomVO rvo = new RandomVO();
		rvo.setNames(names);
		rvo.setCount(2);
		
		RandomDAO dao = new RandomDAOimpl();
		
		
		String[] lucky = dao.getRandom(rvo);
		System.out.println("=====^___^=====");
		for (int i = 0; i < lucky.length; i++) {
			System.out.println(lucky[i]);
		}
		System.out.println("=====^___^=====");
	}

}
