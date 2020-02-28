package binarysearchtreeiterator;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * <p>
 * <p>
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 * <p>
 * <p>
 * Note:
 * <p>
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when *  next() is called.
 */

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

class BSTIterator {
    ArrayDeque<TreeNode> nodes;
    Stack<Integer> minNodes;
    Stack<Integer> temp;

    BSTIterator(TreeNode root) {
        nodes = new ArrayDeque<>();
        minNodes = new Stack<>();
        temp = new Stack<>();
        constructTree(root);
    }

    private void constructTree(TreeNode root) {
        if (root == null) {
            return;
        }
        nodes.add(root);
        int count = 0;
        TreeNode curr, left, right;
        while (!nodes.isEmpty()) {
            curr = nodes.poll();
            // add curr on stack
            if (minNodes.isEmpty()) {
                minNodes.push(curr.val);
            } else if (curr.val < minNodes.peek()) {
                minNodes.push(curr.val);
            } else {
                while (!minNodes.isEmpty() && curr.val > minNodes.peek()) {
                    temp.push(minNodes.pop());
                    count++;
                }
                minNodes.push(curr.val);
                for (int i = 0; i < count; i++) {
                    minNodes.push(temp.pop());
                }
                count = 0;
            }
            left = curr.left;
            right = curr.right;
            if (left != null) {
                nodes.add(left);
            }
            if (right != null) {
                nodes.add(right);
            }
        }
    }

    /**
     * @return the next smallest number
     */
    int next() {
        return minNodes.isEmpty() ? -1 : minNodes.pop();
    }

    /**
     * @return whether we have a next smallest number
     */
    boolean hasNext() {
        return !minNodes.isEmpty();
    }
}

