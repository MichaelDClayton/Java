package search;

import java.util.Iterator;
import java.util.TreeSet;

public class FindLowAndHighNumbers {

	public static void main(String[] args) {
		int[] nums = {10,8,2,5};
		int res = findLow(nums);
		System.out.println(res);
		
	}

	
	public static int findLow(int[] nums) {
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i =0;i<nums.length;i++) {
			set.add(nums[i]);			
		}
		
		int lowest = set.first();
		int highest = set.last();
		int res = highest;
		System.out.println("Lowest is "+lowest);
		System.out.println("Highest is "+highest);
		
		for(int i =++lowest;i<highest;i++) {
			if(!set.contains(i)) {
				return i;
			}
		}
		
		return res;
	}
	
	
	
}
