package search;
/*
 * 	Best-case performance	O(1)
	Average performance	O(log n)
	Worst-case space complexity	O(1)
 */
public class BinarySearch {

	private static int[] nums = {1,4,5,12,15,67,102};
	private static int target = 15;
	public static void main(String[] args) {
		find(0,nums.length-1);
	}
	
	
	public static void find(int low, int high) {
		
		if(high>=low) {
		
		int mid = low +(high - low)/2;
		
		System.out.println("Pivot:"+nums[mid]);
		
		
			if(nums[mid] == target) {
				System.out.println("Found:"+nums[mid]);
			}
			if(nums[mid]>target) {
				find(low,mid-1);
			}
			if(nums[mid]<target) {
				find(mid+1, high);
			}
	
		}	
	}
}
