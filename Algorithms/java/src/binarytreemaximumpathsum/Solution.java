package binarytreemaximumpathsum;

import datastructures.TreeNode;

class Solution {
    private int max_sum = Integer.MIN_VALUE;

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Maximum Path Sum.
     * Memory Usage: 41.3 MB, less than 14.28% of Java online submissions for Binary Tree Maximum Path Sum.
     */
    int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }

    private int max_gain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }
}
