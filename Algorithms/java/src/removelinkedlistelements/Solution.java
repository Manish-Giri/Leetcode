package removelinkedlistelements;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    /**
     * Runtime: 1 ms, faster than 93.14% of Java online submissions for Remove Linked List Elements.
     * Memory Usage: 46.5 MB, less than 24.25% of Java online submissions for Remove Linked List Elements.
     */
    private ListNode removeElements(ListNode head, int val) {
        ListNode current = head, prev = head;
        while (current != null) {
            if (current.val == val) {
                // check if first node in LL
                if (current == head) {
                    head = current.next;
                    prev = current.next;
                } else {
                    prev.next = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}
