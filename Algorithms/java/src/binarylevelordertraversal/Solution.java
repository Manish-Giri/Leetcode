package binarylevelordertraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */


  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) return results;
        ArrayDeque<TreeNode> ad = new ArrayDeque<>();
        // BFS - add root to queue and begin
        ad.add(root);
        TreeNode current;
        List<Integer> level;
        int currLevelLen = -1;
        // run until queue empty
        while(!ad.isEmpty()) {
            // begin current level
            level = new ArrayList<>();
            // run loop for as many children there are in queue
            currLevelLen = ad.size();

            for(int i = 0; i < currLevelLen; i++) {
                // get front of queue
                current = ad.pollFirst();

                if(current != null) {
                    // if a valid node, get its children, add current to level and
                    // add children to queue, if not null
                    TreeNode left = current.left;
                    TreeNode right = current.right;

                    level.add(current.val);

                    if(left != null) {
                        ad.add(left);
                    }

                    if(right != null) {
                        ad.add(right);
                    }
                }
            }
            // ADD current level to results only after this particular level is over
            // which will be when for loop (= size of queue) finishes
            if(!level.isEmpty()) {
                results.add(level);
            }
        }
        return results;

    }
}

/*
Success
Details
Runtime: 1 ms, faster than 72.47% of Java online submissions for Binary Tree Level Order Traversal.
Memory Usage: 39 MB, less than 5.33% of Java online submissions for Binary Tree Level Order Traversal.

 */