package mergesortedarray;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */

class Solution {
    // TODO: Refactor to merge case 1 and case 2b
    void merge(int[] nums1, int m, int[] nums2, int n) {

        // CASE 1 - where nums1 has no initialized elements - just copy over nums2
        if (m == 0) {
            int p = n - 1;
            while (p >= 0) {
                nums1[p] = nums2[p];
                p--;
            }
            return;
        }
        int p = nums1.length - 1, p2 = n - 1, p1 = m - 1;

        // CASE 2 - and p1 >= 0 is required for cases like - [2,0], 1, [1], 1
        // p1 in first iter decrements to -1 and throws exc in 2nd iter
        while (p2 >= 0 && p1 >= 0) {
            if (nums2[p2] >= nums1[p1]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
            }
        }
        // for case 2 - after nums1 has no more elements to compare - copy over nums2
        if (p1 < 0 && p2 >= 0) {
            while (p2 >= 0) {
                nums1[p--] = nums2[p2--];
            }
        }
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
Memory Usage: 38.6 MB, less than 5.94% of Java online submissions for Merge Sorted Array.
 */