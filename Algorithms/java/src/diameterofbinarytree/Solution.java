package diameterofbinarytree;

import datastructures.TreeNode;

class Solution {

    int numberOfNodes = 0;

    /*
     Time Complexity: O(N)O(N). We visit every node once.

     Space Complexity: O(N)O(N), the size of our implicit call stack during our depth-first search.
    */
    int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return numberOfNodes;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        numberOfNodes = Math.max(numberOfNodes, left + right);
        return Math.max(left, right) + 1;
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
    Memory Usage: 39.1 MB, less than 19.48% of Java online submissions for Diameter of Binary Tree.
    */
}
