package InsertIntoaBST;

import datastructures.TreeNode;

/**
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 */

class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search Tree.
     * Memory Usage: 39.9 MB, less than 78.93% of Java online submissions for Insert into a Binary Search Tree.
     * <p>
     * Time - O(log n) | space - O(1)
     */
    TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode prev = null, curr = root;
        while (curr != null) {
            prev = curr;
            if (val < curr.val)
                curr = curr.left;
            else
                curr = curr.right;
        }
        if (val < prev.val)
            prev.left = new TreeNode(val);
        else
            prev.right = new TreeNode(val);
        return root;
    }
}
