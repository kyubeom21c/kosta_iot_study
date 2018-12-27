package test.com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test01List {

	public static void main(String[] args) {
		System.out.println("List...");

		//array >> 정해진 길이를 요구한다.
		//가변적인 길이를 갖을수 있도록 하는 배열.
		//Integer[] arr = new Integer[]{1,2,3};
		//순서(인덱스)있고, 데이터중복 허용
		List<Integer> list = new ArrayList<Integer>();
		list.add(1000);
		list.add(2000);
		list.add(3000);
		list.add(4000);
		list.add(5000);
		list.add(6000);
		list.add(6000);
		list.set(4, 4444);
		list.remove(2);
//		list.clear();
		
		System.out.println(list);
		System.out.println("list.size():"+list.size());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		
		for (Integer x : list) {
			System.out.println(x);
		}
		
		int[] sus = new int[10];
		for (int x : sus) {
			System.out.println(x);
		}
		
	}

}
