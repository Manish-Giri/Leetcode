package findmodeinbst;

import java.util.HashMap;
import java.util.Map;


/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * For example:
 * Given BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * <p>
 * <p>
 * return [2].
 * <p>
 * Note: If a tree has more than one mode, you can return them in any order.
 * <p>
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {

    private HashMap<Integer, Integer> counts = new HashMap<>();

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};
        traverseTree(root);
        int max = counts.values().stream().max(Integer::compareTo).get();
        return counts.entrySet().stream().filter(e -> e.getValue() == max)
                .map(Map.Entry::getKey).mapToInt(i -> i).toArray();

    }

    private void traverseTree(TreeNode root) {
        if (root == null)
            return;
        traverseTree(root.left);
        counts.put(root.val, counts.getOrDefault(root.val, 0) + 1);
        traverseTree(root.right);
    }
}
