package sorting;
/*
 * 	Worst-case analysis:
	The most unbalanced partition occurs when one of the sublists 
	returned by the partitioning routine is of size n − 1. 
	This may occur if the pivot happens to be the smallest or 
	largest element in the list, or in some implementations 
	when all the elements are equal.
	
	
	Worst-case performance	O(n2)
Best-case performance	O(n log n)
Average performance	O(n log n) n
 */
import java.util.Arrays;

public class QuickSort {

	;
	public static void main(String[] args) {
		int[] nums = { 9, 2, 4, 7, 3, 7, 10 };
		System.out.println(Arrays.toString(nums));
 
		int low = 0;
		int high = nums.length - 1;
 
		quickSort(nums, low, high);
		System.out.println(Arrays.toString(nums));
	}
 
	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (i < high)
			quickSort(arr, i, high);
	}
	
}

