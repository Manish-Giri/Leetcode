package validatebst.recursive;

import datastructures.TreeNode;

class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
     * Memory Usage: 38.4 MB, less than 81.14% of Java online submissions for Validate Binary Search Tree.
     * @param root
     * @return
     */
    boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // using Long to bypass leetcode test case where BST node val = integer.max_value
    private boolean helper(TreeNode root, long min, long max) {
        if(root == null) return true;
        // false conditions
        if(root.val <= min || root.val >= max) return false;
        // recursively check left & right subtrees
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);

    }
}
