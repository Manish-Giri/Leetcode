package palindromelinkedlist;

import datastructures.ListNode;

import java.util.ArrayList;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
class Solution {

    /**
     * Runtime: 3 ms, faster than 30.74% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 43.1 MB, less than 53.13% of Java online submissions for Palindrome Linked List.
     *
     * Time - O(n) | Space - O(n)
     * @param head
     * @return
     */
    private boolean isPalindrome(ListNode head) {
        ArrayList<Integer> nodes = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            nodes.add(curr.val);
            curr = curr.next;
        }
        curr = reverseList(head);
        int i = 0;
        while(curr != null) {
            if(curr.val != nodes.get(i)) {
                return false;
            }
            curr = curr.next;
            i++;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, temp = null;
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}
