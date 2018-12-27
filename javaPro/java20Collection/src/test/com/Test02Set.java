package test.com;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test02Set {

	public static void main(String[] args) {
		System.out.println("Set...");

		//순서(인덱스)없다, 데이터중복허용안함
		Set<String> s = new HashSet<String>();
		s.add("kim1");
		s.add("kim2");
		s.add("kim");
		s.add("kim");
		s.add("kim3");
		s.add("kim3");
		s.add("kim3");
		s.remove("kim3");
//		s.clear();
		
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		
		for (String x : s) {
			System.out.println(x);
		}
	}

}
