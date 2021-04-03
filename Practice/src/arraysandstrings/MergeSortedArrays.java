package arraysandstrings;

class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
        [4,5,6,0,0,0]
        3
        [1,2,3]
        3
**/
        int nums1Pointer = m - 1;
        int nums2Pointer = n - 1;
        
        for(int p = m + n - 1;p >=0; p--){
            if(nums2Pointer<0){
                break;
            }
            if(nums1Pointer >= 0 && nums1[nums1Pointer] > nums2[nums2Pointer]){
                nums1[p] = nums1[nums1Pointer--];
            }else{
                nums1[p] = nums2[nums2Pointer--];
            }
        }
    }
}