package maximumdepthofbinarytree;

import datastructures.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its depth = 3.
 */

class Solution {

    /**
     * Approach 1 - Recursion
     *
     * @param root
     * @return Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
     * Memory Usage: 39.8 MB, less than 75.27% of Java online submissions for Maximum Depth of Binary Tree.
     */

    int maxDepthRec(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepthRec(root.left), maxDepthRec(root.right)) + 1;
    }
}
