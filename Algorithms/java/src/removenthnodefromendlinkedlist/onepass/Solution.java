package removenthnodefromendlinkedlist.onepass;

import datastructures.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Follow up:
 * Could you do this in one pass?
 */

class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
     * Memory Usage: 37.8 MB, less than 63.58% of Java online submissions for Remove Nth Node From End of List.
     *
     * @param head
     * @param n
     * @return
     */
    private ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int count = 1;
        ListNode fast = head, slow = head, prev = null;
        while (count != n) {
            if (fast == null) break;
            fast = fast.next;
            count++;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        // delete nth node from end if this is not the only element in list
        if (prev == null) {
            if (fast == slow)
                return null;
            else {
                // delete slow
                head = slow.next;
            }
        } else
            prev.next = slow.next;
        return head;
    }


}
