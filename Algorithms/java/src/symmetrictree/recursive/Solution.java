package symmetrictree.recursive;

import datastructures.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * Follow up: Solve it both recursively and iteratively.
 */

class Solution {

    /**
     * Success
     * Details
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
     * Memory Usage: 37.3 MB, less than 98.55% of Java online submissions for Symmetric Tree.
     * @param root
     * @return
     */
    boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode first, TreeNode second) {
        if(first == null && second == null) return true;
        if ((first == null && second != null) ||
                (first != null && second == null) ||
                (first.val != second.val))
            return false;
        else
            return helper(first.right, second.left) && helper(first.left, second.right);
    }
}
