package constructbstfrompreordertraversal;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * <p>
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 * Note:
 * <p>
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 */
class Solution {
    /**
     * Approach Three - using Stack (Iteration)
     * Time - O(n), Space - O(n) for stack
     * <p>
     * Runtime: 1 ms, faster than 25.16% of Java online submissions
     * Memory Usage: 37.5 MB, less than 6.00% of Java online submissions
     * <p>
     * TODO: Explore other solutions
     */
    TreeNode bstFromPreorder_ApproachThree(int[] preorder) {
        int n = preorder.length;
        if (n == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.push(root);

        for (int i = 1; i < n; i++) {
            // take the last element of the deque as a parent
            // and create a child from the next preorder element
            TreeNode node = deque.peek();
            TreeNode child = new TreeNode(preorder[i]);
            // adjust the parent 
            while (!deque.isEmpty() && deque.peek().val < child.val)
                node = deque.pop();

            // follow BST logic to create a parent-child link
            if (node.val < child.val) node.right = child;
            else node.left = child;
            // add the child into deque
            deque.push(child);
        }
        return root;
    }
}
