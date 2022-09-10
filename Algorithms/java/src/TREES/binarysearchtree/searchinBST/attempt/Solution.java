package TREES.binarysearchtree.searchinBST.attempt;

import TREES.TreeNode;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 */

 class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in a Binary Search Tree.
     * Memory Usage: 51.5 MB, less than 54.56% of Java online submissions for Search in a Binary Search Tree.
     */
     TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val)
            return root;
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
