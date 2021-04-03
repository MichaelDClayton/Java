/*
 * find maximum diff with arr[j] - arr[i].
 */

package arraysandstrings;

import java.util.Arrays;

public class MaxDiffWithinArray {

	public static void main(String[] args) {
		int[] arr = {10, 3, 8, 4, 13};
		
		int low = 0;
		int high = arr.length - 1; 
		
		int[] res = sort(arr, low, high);
		System.out.println(Arrays.toString(arr));
		
		//now subtract arr[0] from arr[arr.length-1];
		int subtraction = arr[arr.length-1] - arr[0];
		System.out.println(subtraction);
		
		
		
		int diff = diff(arr);
		System.out.println("More Elegant approach: "+diff);
	}
	
	
	
	public static int[] sort(int[] arr, int low, int high) {
		if(arr == null || arr.length == 0)
			return null;
		
		
		
		if(low >= high)
			return null;
		
		int mid = low + (high - low)/2;
		int pivot = arr[mid];
		int i = low;
		int j = high;
		
		while(i <= j) {
			while(arr[i] < pivot) {
				i++;
			}
			
			while(arr[j] > pivot) {
				j--;
			}
			
			if(i<=j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j--;
				i++;
			}
			
			if(low < j) {
				sort(arr, low, j);
			}
			if(high > i) {
				sort(arr, i, high);
			}
		}
		
		return arr;
		
		
	}
	
	/*
	 * this is O(n^2)
	 */
	public static int diff(int[] A)
    {
        int diff = Integer.MIN_VALUE;
 
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                diff = Integer.max(diff, A[j] - A[i]);
            }
        }
 
        return diff;
    }
	
	
	/*
	 * this is linear
	 */
	public static int diff2(int[] A)
    {
        int diff = Integer.MIN_VALUE;
        int n = A.length;
        int max_so_far = A[n-1];
 
        // traverse the array from the right and keep track of the maximum element
        for (int i = n - 2; i >= 0; i--)
        {
            // update `max_so_far` if the current element is greater than the
            // maximum element
            if (A[i] > max_so_far) {
                max_so_far = A[i];
            }
            // if the current element is less than the maximum element,
            // then update the difference if required
            else {
                diff = Integer.max(diff, max_so_far - A[i]);
            }
        }
 
        // return difference
        return diff;
    }
}
