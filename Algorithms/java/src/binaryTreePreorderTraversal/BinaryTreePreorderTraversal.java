package binaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    private List<Integer> traversal = new ArrayList<>();

    private List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        } else {
            traversal.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return traversal;

    }
}
