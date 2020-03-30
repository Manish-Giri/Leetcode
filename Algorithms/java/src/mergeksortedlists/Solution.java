package mergeksortedlists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    /*
    Approach 1 - Combine each linkedlist's element's value into an AL
    sort the AL, and create a new LL from the AL and return it
    Time - O(n logn) for sort, Space - O(n) for the auxiliary list

    Runtime: 22 ms, faster than 18.99% of Java online submissions for Merge k Sorted Lists.
    Memory Usage: 45.6 MB, less than 17.49% of Java online submissions for Merge k Sorted Lists.
    */
    ListNode mergeKLists_CombineAll(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for (ListNode l : lists) {
            ListNode curr = l;
            while (curr != null) {
                list.add(curr.val);
                curr = curr.next;
            }
        }
        list.sort(Comparator.naturalOrder());
        ListNode current = null, head = current;
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            int v = iter.next();
            if (current == null) {
                current = new ListNode(v);
                head = current;
            } else {
                current.next = new ListNode(v);
                current = current.next;
            }

        }
        return head;

    }

    /**
     * Approach 2 -  compare each LL's node one by one, for all k lists
     * In every iteration, connect head/current of result node to minimum of k lists
     * Thereby avoiding creating extra array to hold result nodes
     * <p>
     * Time complexity : O(kN) where k is the number of linked lists.
     * <p>
     * - Almost every selection of node in final linked costs O(k)(k-1 times comparison).
     * - There are N nodes in the final linked list.
     * <p>
     * Space complexity :
     * <p>
     * O(n) Creating a new linked list costs O(n) space.
     * O(1) It's not hard to apply in-place method - connect selected nodes instead of creating new nodes to fill the       * new linked list.
     * Runtime: 243 ms, faster than 10.06% of Java online submissions for Merge k Sorted Lists.
     * <p>
     * Memory Usage: 41.7 MB, less than 33.88% of Java online submissions for Merge k Sorted Lists.
     */
    ListNode mergeKLists_CompareEach(ListNode[] lists) {
        ListNode current = null, head = null;
        if (lists.length == 0) return head;
        int min = Integer.MAX_VALUE, minIdx = -1;
        while (true) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val <= min) {
                    min = lists[i].val;
                    minIdx = i;
                }
            }
            if (minIdx == -1) {
                break;
            }
            if (head == null) {
                head = lists[minIdx];
                current = head;
            } else {
                current.next = lists[minIdx];
                current = current.next;
            }

            lists[minIdx] = lists[minIdx].next;
            minIdx = -1;
            min = Integer.MAX_VALUE;
        }

        return head;
    }
}
