package validatebst;

import datastructures.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validator(root, null, null);
    }

    private boolean validator(TreeNode node, Integer lower, Integer upper) {
        if(node == null)
            return true;
        int val = node.val;
        // check upper & lower limits
        if(lower != null && val <= lower)
            return false;
        if(upper != null && val >= upper)
            return false;
        return validator(node.left, lower, val) && validator(node.right, val, upper);
    }
}

/*
Details
Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
Memory Usage: 40.7 MB, less than 5.58% of Java online submissions for Validate Binary Search Tree.
 */