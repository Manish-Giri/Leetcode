package squaresofsortedarray;

import java.util.Arrays;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */

 class Solution {
     // 1. Brute Force solution - sorting
     // Time: O(n logn) - requires sorting of array of squares
     // Space: O(n) - to store array of squares
     /*
    int[] sortedSquares(int[] A) {
        return Arrays.stream(A).map(i -> i * i).sorted().toArray();
     }

     Runtime: 8 ms, faster than 10.17% of Java online submissions for Squares of a Sorted Array.
     Memory Usage: 44.2 MB, less than 5.48% of Java online submissions for Squares of a Sorted Array.
     */

     // 2. Optimal solution - two pointer approach
     // Time: O(n) - since we're only iterating over input array once
    int[] sortedSquares(int[] A) {
        // A. find index of first +ve element
        int pos = 0;
        while(pos < A.length && A[pos] < 0) {
            pos++;
        }
        //B. find index of first largest -ve element (+ve elem idx -1)
        // this element will have the smallest square among squares of -ve elements
        // traverse backwards
        int neg = pos - 1;
        int[] res = new int[A.length];
        int idx = 0;
        while(neg >= 0 && pos < A.length) {
            int posSq = A[pos] * A[pos];
            int negSq = A[neg] * A[neg];
            if(negSq < posSq) {
                res[idx++] = negSq;
                neg--;
            }
            else {
                res[idx++] = posSq;
                pos++;
            }
        }

        // copy left over elements
        while(neg >= 0) {
            res[idx++] = A[neg] * A[neg];
            neg--;
        }
        while(pos < A.length) {
            res[idx++] = A[pos] * A[pos];
            pos++;
        }
        return res;
    }

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Squares of a Sorted Array.
    Memory Usage: 42.3 MB, less than 63.41% of Java online submissions for Squares of a Sorted Array.
     */
}

/*
Approach 2: Two Pointer
Intuition

Since the array A is sorted, loosely speaking it has some negative elements with squares in decreasing order, then some non-negative elements with squares in increasing order.

For example, with [-3, -2, -1, 4, 5, 6], we have the negative part [-3, -2, -1] with squares [9, 4, 1], and the positive part [4, 5, 6] with squares [16, 25, 36]. Our strategy is to iterate over the negative part in reverse, and the positive part in the forward direction.

Algorithm

We can use two pointers to read the positive and negative parts of the array - one pointer j in the positive direction, and another i in the negative direction.

Now that we are reading two increasing arrays (the squares of the elements), we can merge these arrays together using a two-pointer technique.
 */