package signofproductofarray.bruteforce;

/**
 * There is a function signFunc(x) that returns:
 * <p>
 * 1 if x is positive.
 * -1 if x is negative.
 * 0 if x is equal to 0.
 * You are given an integer array nums. Let product be the product of all values in the array nums.
 * <p>
 * Return signFunc(product).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,-2,-3,-4,3,2,1]
 * Output: 1
 * Explanation: The product of all values in the array is 144, and signFunc(144) = 1
 * Example 2:
 * <p>
 * Input: nums = [1,5,0,2,-3]
 * Output: 0
 * Explanation: The product of all values in the array is 0, and signFunc(0) = 0
 * Example 3:
 * <p>
 * Input: nums = [-1,1,-1,1,-1]
 * Output: -1
 * Explanation: The product of all values in the array is -1, and signFunc(-1) = -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * -100 <= nums[i] <= 100
 */

class Solution {

   /**
    * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sign of the Product of an Array.
    * Memory Usage: 38.6 MB, less than 65.05% of Java online submissions for Sign of the Product of an Array.
    * @param nums
    * @return
    */
    int arraySign(int[] nums) {
        boolean isPos = true, isZero = false;
        for (int n : nums) {
            if (n > 0) {
                if (isPos) {
                    isPos = true; isZero = false;
                } else if (isZero) {
                    isPos = false; isZero = true;
                } else {
                    isPos = false; isZero = false;
                }
            } else if (n == 0) {
                isPos = false; isZero = true;
            } else {
                if (isZero) {
                    isPos = false; isZero = true;
                } else if (!isPos) {
                    isPos = true; isZero = false;
                } else {
                    isPos = false; isZero = false;
                }
            }
        }
        return isZero ? 0 : isPos ? 1 : -1;
    }

}

   /**
     * Runtime: 1 ms, faster than 19.87% of Java online submissions for Sign of the Product of an Array.
     * Memory Usage: 38.8 MB, less than 50.88% of Java online submissions for Sign of the Product of an Array.
     *
     * @param nums
     * @return
     */
    /*
    public int arraySign(int[] nums) {
     boolean isPos = true, isNeg = false, isZero = false;
     for(int n: nums) {
      if(n > 0) {
       if(isPos) {
        isPos = true; isNeg = false; isZero = false;
       }
       else if(isZero) {
        isPos = false; isNeg = false; isZero = true;
       }
       else if(isNeg) {
        isPos = false; isNeg = true; isZero = false;
       }
      }
      else if(n == 0) {
       isPos = false; isNeg = false; isZero = true;
      }

      else if(n < 0) {
       if(isZero) {
        isPos = false; isNeg = false; isZero = true;
       }
       else if(isNeg) {
        isPos = true; isNeg = false; isZero = false;
       }
       else {
        isNeg = true; isPos = false; isZero = false;
       }
      }
     }
     if(isZero) return 0;
     return isPos ? 1 : -1;
    } */
