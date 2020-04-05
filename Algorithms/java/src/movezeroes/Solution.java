package movezeroes;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */

class Solution {

    /*
    Details
    Runtime: 3 ms, faster than 14.27% of Java online submissions for Move Zeroes.
    Memory Usage: 40.3 MB, less than 5.59% of Java online submissions for Move Zeroes.

    Brute Force solution - Time O(n^2)
     */
    void moveZeroes_ApproachZero(int[] nums) {
        int i = 0, j = -1;
        while (i < nums.length - 1) {
            if (nums[i] != 0) {
                i++;
                continue;
            }
            // found 0
            // look for first non zero element
            j = i + 1;
            while (nums[j] == 0) {
                j++;
                if (j == nums.length)
                    return;
            }
            // found non zero - swap
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
        }
    }


    // Approach 2 - Optimal space, sub optimal # of operations
    /* Details
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
    Memory Usage: 40.1 MB, less than 5.59% of Java online submissions for Move Zeroes.

    Time - O(n) with sub-optimal number of operations, because too many writes of zeroes in 2nd iteration
    for arrays which are mostly zeroes - [0,0,0,0,0,1]
    Space - O(1)
     */
    void moveZeroes_ApproachTwo(int[] nums) {
        int placeNextNonZeroElementAt = 0;
        // 1st iteration - copy all non zeroes, overwrite
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[placeNextNonZeroElementAt++] = nums[i];
            }
        }
        // 2nd iteration - set remaining zeroes
        for (int i = placeNextNonZeroElementAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /*
    Approach 3 - Optimal space, optimal # of operations
    Details
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
    Memory Usage: 40.5 MB, less than 5.59% of Java online submissions for Move Zeroes.

    Swap non zero elements with zero elements in same iteration, avoids a second pass to write zeroes
    efficient when array has many zeroes
    however same as other approaches where array has mostly non zero elements

    Time - O(n) with optimal(minimum) # of operations, because we swap elements in one iteration itself
    doesn't require a second pass to copy zeroes
     */
    void moveZeroes(int[] nums) {
        for (int placeNextNonZeroElementAt = 0, curr = 0; curr < nums.length; curr++) {
            if (nums[curr] != 0) {
                swap(nums, placeNextNonZeroElementAt, curr);
                placeNextNonZeroElementAt++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

