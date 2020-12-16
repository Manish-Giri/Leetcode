package mergesortedarray.optimized;

 class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
     * Memory Usage: 39.1 MB, less than 63.80% of Java online submissions for Merge Sorted Array.
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
     void merge(int[] nums1, int m, int[] nums2, int n) {
        // assign pointers for nums1 end, nums1 initialized and nums2
        int p = nums1.length-1;
        int p1 = m-1, p2 = n-1;

        // copy over elements from nums2 after comparing with nums1
        while(p1 >= 0 && p2 >= 0) {
            if(nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            }
            else {
                nums1[p--] = nums2[p2--];
            }
        }

        // copy over remaining elements from p2
        while(p2 >= 0) nums1[p--] = nums2[p2--];
    }
}
