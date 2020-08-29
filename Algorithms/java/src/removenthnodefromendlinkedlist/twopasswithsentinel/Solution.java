package removenthnodefromendlinkedlist.twopasswithsentinel;

import datastructures.ListNode;

class Solution {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
     * Memory Usage: 37.9 MB, less than 54.23% of Java online submissions for Remove Nth Node From End of List.
     *
     * Uses formula: nth node from end => (length - n + 1)th node from beginning
     * @param head
     * @param n
     * @return
     */
    private ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode current = head, sentinel = new ListNode(0);
        sentinel.next = head;
        int pos = 0, length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        pos = length - n + 1;
        current = sentinel;
        for (int i = 1; i < pos; i++) {
            current = current.next;
        }
        current.next = current.next.next;

        return sentinel.next;
    }


}
