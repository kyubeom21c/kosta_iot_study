package test.com;

import java.util.Random;

public class RandomDAOimpl implements RandomDAO{
	
	Random r = new Random();
	
	@Override
	public String[] getRandom(RandomVO rvo) {
		System.out.println("getRandom()...");
		System.out.println(
				"rvo.getNames().length:"+
						rvo.getNames().length);
//		for (int i = 0; i < rvo.getNames().length; i++) {
//			System.out.println(rvo.getNames()[i]);
//		}
		String[] lucky = new String[rvo.getCount()];
		
		for (int i = 0; i < lucky.length; i++) {
			int rsu = r.nextInt(rvo.getNames().length);
//			System.out.println("rsu:"+rsu);
			String name = rvo.getNames()[rsu];
//			System.out.println(name);
			lucky[i] = name;
		}
		
		return lucky;
	}

}
