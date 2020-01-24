package addtwonumbers;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, currSum = 0, sum;
        boolean isHeadSet = false;

        ListNode result = null, current = null;

        // TODO: Refactor this while to loop as long as either list has a node - remove second if/while
        while (l1 != null && l2 != null) {
            sum = carry + l1.val + l2.val;
            if (sum > 9) {
                carry = sum / 10;
                currSum = sum % 10;
            } else {
                carry = 0;
                currSum = sum;
            }

            if (!isHeadSet) {
                current = new ListNode(currSum);
                result = current;
                isHeadSet = true;
            } else {
                current.next = new ListNode(currSum);
                current = current.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }


        // check if either l1 or l2 still has nodes left
        // [1], [9,9] -> [0, 0, 1]
        if (l1 != null || l2 != null) {
            ListNode rem = l1 != null ? l1 : l2;
            while (rem != null || carry > 0) {
                if (rem == null) {
                    current.next = new ListNode(carry);
                    current = current.next;
                    carry = 0;
                    break;
                } else {

                    sum = carry + rem.val;

                    if (sum > 9) {
                        carry = sum / 10;
                        currSum = sum % 10;
                        //carry = 0;
                    } else {
                        currSum = sum;
                        carry = 0;
                    }
                    current.next = new ListNode(currSum);
                    current = current.next;
                    rem = rem.next;
                }

            }
        }

        // check if carry still has a value
        if (carry > 0) {
            current.next = new ListNode(carry);
            current = current.next;
        }
        return result;
    }
}
