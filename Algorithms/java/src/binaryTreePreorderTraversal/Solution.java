package binaryTreePreorderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
class Solution {
    // ITERATIVE SOLUTION FOR PREORDER TRAVERSAL

    List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> traversal = new ArrayList<>();
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        if (root == null) {
            return traversal;
        }
        nodes.add(root);
        TreeNode temp = null, left = null, right = null;
        while (!nodes.isEmpty()) {
            temp = nodes.pollFirst();
            traversal.add(temp.val);
            // get children
            left = temp.left;
            right = temp.right;
            // left child should be visited first before current right child
            if (left != null)
                nodes.addFirst(left);
            // right child added at end
            if (right != null) {
                nodes.add(right);
            }
        }
        return traversal;

    }
}
