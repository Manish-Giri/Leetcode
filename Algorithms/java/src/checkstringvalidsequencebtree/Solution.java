package checkstringvalidsequencebtree;

import datastructures.TreeNode;

/**
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.
 * <p>
 * We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
 * Other valid sequences are:
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 * Output: false
 * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 * Output: false
 * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 5000
 * 0 <= arr[i] <= 9
 * Each node's value is between [0 - 9].
 */

class Solution {
    private boolean validSequence = false;

    /**
     * Runtime: 17 ms
     * Memory Usage: 40.6 MB
     */
    boolean isValidSequence(TreeNode root, int[] arr) {
        String sequence = "";
        StringBuilder arrSeq = new StringBuilder();
        for (int i : arr) arrSeq.append(i);
        dfs(root, sequence, arrSeq.toString());
        return validSequence;
    }

    private void dfs(TreeNode root, String seq, String arrSeq) {
        if (root == null) return;
        // check sequence if leaf node
        //sequence.append(root.val);
        if (root.left == null && root.right == null) {
            seq += root.val;
            boolean res = seq.equals(arrSeq);
            if (res)
                validSequence = true;
            return;
        }
        dfs(root.left, seq + root.val, arrSeq);
        dfs(root.right, seq + root.val, arrSeq);
    }
}
