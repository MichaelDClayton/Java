package search;

public class FindBiggestDifference {

	public static void main(String[] args) {
		int k = 6;
		int[] arr = new int[] {3,4,2,8,7,10};
		int maxDiff = findMaxDifference(k,arr);
	}
	
	public static int findMaxDifference(int k, int[] arr) {
		int currentMaxPosition;
		int currentMax = arr[arr.length-1];
		
		for(int i =0;i<arr.length;i++) {
			if(arr[i] > currentMax) {
				currentMax = arr[i];
				currentMaxPosition = i;
			}
		}
		
		
		
		return -1;
		
	}
	
}
