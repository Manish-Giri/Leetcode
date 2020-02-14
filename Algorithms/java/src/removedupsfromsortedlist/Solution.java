package removedupsfromsortedlist;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        int lastElement = -1;
        ListNode current = head, prev = head;
        while (current != null) {
            if (current != head) {
                if (lastElement == current.val) {
                    prev.next = current.next;
                } else {
                    lastElement = current.val;
                    prev = current;
                }
            } else {
                lastElement = current.val;
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}

/*
 Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
 Memory Usage: 41 MB, less than 7.14% of Java online submissions for Remove Duplicates from Sorted List.
 */