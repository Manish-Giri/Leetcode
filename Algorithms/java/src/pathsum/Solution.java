package pathsum;

import datastructures.TreeNode;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */

class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
     * Memory Usage: 39.2 MB, less than 25.27% of Java online submissions for Path Sum.
     *
     * @param root
     * @param targetSum
     * @return
     */
    boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, 0, targetSum);
    }

    private boolean helper(TreeNode curr, int sum, int targetSum) {
        // this check as the first statement in the method won't work because curr's sum is not
        // taken into account, when matching with targetSum
        // if(sum == targetSum) return true;
        // base case -> when curr node is null, it is not a leaf, so return false
        if(curr == null) return false;
        sum += curr.val;
        // for a leaf - both children must be null, so at this point -> check if sums match
        if(curr.left == null && curr.right == null) return sum == targetSum;
        // else -> recurse for left and right child (not the OR), to return "true" from either child
        return helper(curr.left, sum, targetSum) || helper(curr.right, sum, targetSum);

    }

}
