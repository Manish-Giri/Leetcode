package binarytreepostordertraversal;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

 class IterativeSolution {
     List<Integer> postorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        LinkedList<Integer> traversal = new LinkedList<>();
        // empty root
        if(root == null)
            return traversal;
        // add root
        nodes.add(root);
        TreeNode left, right, curr;
        while(!nodes.isEmpty()) {
            // fetch last element in list
            curr = nodes.pollLast();
            // add it to first position in traversal
            traversal.addFirst(curr.val);
            left = curr.left;
            right = curr.right;
            // add left and right children
            if(left != null) {
                nodes.add(left);
            }
            if(right != null) {
                nodes.add(right);
            }

        }
        return traversal;
    }
}
