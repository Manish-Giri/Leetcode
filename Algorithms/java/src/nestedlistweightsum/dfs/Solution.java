package nestedlistweightsum.dfs;

import java.util.List;

/**
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.
 * <p>
 * The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
 * <p>
 * Return the sum of each integer in nestedList multiplied by its depth.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.
 * Example 2:
 * <p>
 * <p>
 * Input: nestedList = [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3. 1*1 + 4*2 + 6*3 = 27.
 * Example 3:
 * <p>
 * Input: nestedList = [0]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nestedList.length <= 50
 * The values of the integers in the nested list is in the range [-100, 100].
 * The maximum depth of any integer is less than or equal to 50.
 */


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    // Constructor initializes an empty nested list.
    // NestedInteger();

    // Constructor initializes a single integer.
    // NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}

class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Nested List Weight Sum.
     * Memory Usage: 36.3 MB, less than 87.48% of Java online submissions for Nested List Weight Sum.
     *
     * @param nestedList
     * @return
     */
    int depthSum(List<NestedInteger> nestedList) {
        int depth = 1;
        return helper(nestedList, depth);
        //return sum;
    }

    private int helper(List<NestedInteger> nestedList, int depth) {
        int total = 0;
        for (var currElem : nestedList) {
            if (currElem.isInteger()) {
                total += depth * currElem.getInteger();
            } else {
                total += helper(currElem.getList(), depth + 1);
            }
        }
        return total;
    }
}
