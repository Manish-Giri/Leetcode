package mergetwosortedlists;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultHead = null, resultCurr = null, temp = null;
        ListNode l1H = l1, l2H = l2;
        boolean firstNode = true;
        while (l1H != null && l2H != null) {
            if (l1H.val <= l2H.val) {
                temp = new ListNode(l1H.val);
                if (firstNode) {
                    resultCurr = temp;
                    resultHead = resultCurr;
                    firstNode = false;
                } else {
                    resultCurr.next = temp;
                    resultCurr = resultCurr.next;
                }
                l1H = l1H.next;
            } else {
                temp = new ListNode(l2H.val);
                if (firstNode) {
                    resultCurr = temp;
                    resultHead = resultCurr;
                    firstNode = false;
                } else {
                    resultCurr.next = temp;
                    resultCurr = resultCurr.next;
                }
                l2H = l2H.next;
            }


        }

        // outside while
        while (l1H != null) {
            temp = new ListNode(l1H.val);
            if (firstNode) {
                resultCurr = temp;
                resultHead = resultCurr;
                firstNode = false;
            } else {
                resultCurr.next = temp;
                resultCurr = resultCurr.next;
            }

            l1H = l1H.next;
        }

        while (l2H != null) {
            temp = new ListNode(l2H.val);
            if (firstNode) {
                resultCurr = temp;
                resultHead = resultCurr;
                firstNode = false;
            } else {
                resultCurr.next = temp;
                resultCurr = resultCurr.next;
            }
            l2H = l2H.next;
        }

        return resultHead;
    }
}

/*
Success
Details
Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
Memory Usage: 38.8 MB, less than 19.53% of Java online submissions for Merge Two Sorted Lists.
 */