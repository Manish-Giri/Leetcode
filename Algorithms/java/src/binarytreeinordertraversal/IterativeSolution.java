package binarytreeinordertraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class IterativeSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> trav = new ArrayList<>();
        if (root == null)
            return trav;
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;
        while (current != null || !s.isEmpty()) {
            while (current != null) {
                // add all left nodes first
                s.push(current);
                current = current.left;
            }
            // pop out top of stack and visit
            current = s.pop();
            trav.add(current.val);
            // make current as current's right child and start over (left -> root -> right)
            current = current.right;
        }

        return trav;
    }
}

/*
Success
Details
Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
Memory Usage: 37.4 MB, less than 5.11% of Java online submissions for Binary Tree Inorder Traversal.

 */