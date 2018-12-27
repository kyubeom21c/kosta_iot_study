package test.com;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Test03Map {

	public static void main(String[] args) {
		System.out.println("Map...");
		
		//반드시 키,값 >>> <key,value>
		//key:유일키(중복허용안함), value:중복허용
		Map<String, Double> m = 
				new Hashtable<String, Double>();
		m.put("key1", 3.14);
		m.put("key1", 3.14333);
		m.put("b_avg", 99.8);
		m.put("d_avg", 200.0);
		
//		m.remove("key1");
//		m.clear();
		
		System.out.println(m.get("key1"));
		System.out.println(m.get("b_avg"));
		System.out.println(m.get("d_avg"));
		
		Set<String> ks = m.keySet();
		for (String x : ks) {
			System.out.println(x+":"+m.get(x));
		}
		
	}

}
