package test.com;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test04Lotto {

	public static void main(String[] args) {
		System.out.println("Lotto...");
		
		//Set...1~45
		Random r = new Random();
		Set<Integer> s = new HashSet<>();
		while(s.size()<6) {
			int su = r.nextInt(45)+1;
			s.add(su);
			System.out.println(su);
		}
		System.out.println("");
		
		int[] sus = new int[s.size()];
		int count = 0;
		for (Integer x : s) {
			sus[count] = x;
			count++;
			System.out.print(x+" ");
		}
		System.out.println();
		
		Arrays.sort(sus);
		for (int x : sus) {
			System.out.print(x+" ");
		}
	}

}
