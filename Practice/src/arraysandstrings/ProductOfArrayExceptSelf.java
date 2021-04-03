package arraysandstrings;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] nums = {0,1};
		int[] res = getProductArray(nums);
		
		for(int i : res) {
			System.out.println(i);
		}
	}
	
	public static int[] getProductArray(int[] nums) {
		int[] output = new int[nums.length];
		int index = 0;
		//1,2,3,4
		/** 
		 * multiple and get the factorial...then divide by.
		 */
		int sum = 1;
		for(int i =nums.length-1;i>=0;i--) {
			sum*=nums[i];
		}
		System.out.println("early sum: "+sum);
		output[index++] = sum;
		for(int i = 0;i<nums.length;i++) {
			int newSum = sum/nums[i];
			if(newSum!=0 && nums[i] > 1) {
				output[index++] = sum/nums[i];
			}
			
		}
		
		return output;
	}
			
			
}
