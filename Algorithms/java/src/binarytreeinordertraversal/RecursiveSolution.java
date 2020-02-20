package binarytreeinordertraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */

class RecursiveSolution {

    private List<Integer> traversal = new ArrayList<>();

    private List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return traversal;
    }

    // RECURSIVE SOLUTION
    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        traversal.add(root.val);
        inOrder(root.right);
    }
}
