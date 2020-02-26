package binarytreepostordertraversal;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [3,2,1]
 */

 class RecursiveSolution {
    List<Integer> al = new ArrayList<>();
     List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return al;
    }
    private void helper(TreeNode root) {
        if(root == null)
            return;
        helper(root.left);
        helper(root.right);
        al.add(root.val);
    }



}
