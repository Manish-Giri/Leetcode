package swapnodesinpairs.recursive;

import datastructures.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 * <p>
 * Input: head = []
 * Output: []
 * Example 3:
 * <p>
 * Input: head = [1]
 * Output: [1]
 */

class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
     * Memory Usage: 36.9 MB, less than 27.56% of Java online submissions for Swap Nodes in Pairs.
     */
    ListNode swapPairs(ListNode head) {
        return swap(head);
    }

    private ListNode swap(ListNode head) {
        // base case - when last node in list (no pair) or null node, return node
        if (head == null || head.next == null) return head;
        // 1. create refs to curr and next node
        // 2. make curr node's next = node returned by next recursive call
        // 3. make next node's next = curr node
        // 4. make head as next node
        // 5. return updated head (second node)
        ListNode first = head;
        ListNode second = head.next;

        first.next = swap(second.next);
        second.next = first;
        head = second;
        return head;
    }
}
