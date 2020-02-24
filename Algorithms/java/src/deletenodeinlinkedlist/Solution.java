package deletenodeinlinkedlist;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * <p>
 * Given linked list -- head = [4,5,1,9], which looks like following:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * Example 2:
 * <p>
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 * <p>
 * <p>
 * Note:
 * <p>
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class Solution {
    // 1->2->3->4->5->null, node = 3
    // 1. copy value of 3.next (4) to 3
    // 2. list becomes 1->2->4->4->5->null
    // 3. make this node's next point to next.next
    // 4. list becomes 1->2->4->5->null
    void deleteNode(ListNode node) {
        // copy value of node.next to this node
        node.val = node.next.val;
        // make this node's next point to next's next
        node.next = node.next.next;
    }
}

// Time - O(1)
/*
Success
Details
Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
Memory Usage: 40.4 MB, less than 5.09% of Java online submissions for Delete Node in a Linked List.
 */