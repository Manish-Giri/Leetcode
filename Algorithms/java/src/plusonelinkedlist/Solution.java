package plusonelinkedlist;

import datastructures.ListNode;

/**
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Example :
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 */

class Solution {
    ListNode plusOne(ListNode head) {
        if (head == null) return null;
        ListNode revHead = reverse(head);
        int carry = 0, sum = 1;
        ListNode prev = null, curr = revHead;
        while (curr != null) {
            sum += curr.val + carry;
            if (sum > 9) {
                curr.val = 0;
                carry = 1;
            } else {
                curr.val = sum;
                carry = 0;
            }
            prev = curr;
            curr = curr.next;
            sum = 0;
        }
        if (curr == null && carry == 1)
            prev.next = new ListNode(carry);
        return reverse(revHead);

    }

    private ListNode reverse(ListNode head) {
        ListNode current = head, prev = null, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    /*
    Success
    Details
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One Linked List.
    Memory Usage: 37.8 MB, less than 8.33% of Java online submissions for Plus One Linked List.
     */
}
