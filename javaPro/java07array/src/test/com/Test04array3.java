package test.com;

import java.util.Arrays;

public class Test04array3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("array...");
		
		int[] sus = new int[3];
		int[] sus2 = new int[] {0,0,0};
		System.out.println(sus.length);
		for (int i = 0; i < sus.length; i++) {
			System.out.println(sus[i]);
		}
		System.out.println();
		System.out.println(sus==sus2);
		System.out.println(sus.equals(sus2));
		System.out.println(Arrays.equals(sus, sus2));
		System.out.println(Arrays.compare(sus, sus2)==0);
		
		
		Integer[] nums = new Integer[3];
		nums[0] = 0;
		nums[1] = 0;
		nums[2] = 0;
		Integer[] nums2 = new Integer[] {0,0,0};
		System.out.println(nums.length);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		System.out.println(nums.equals(nums2));
		System.out.println(nums==nums2);
		System.out.println(Arrays.equals(nums, nums2));
		System.out.println(Arrays.compare(nums, nums2)==0);
		
		
	}

}
