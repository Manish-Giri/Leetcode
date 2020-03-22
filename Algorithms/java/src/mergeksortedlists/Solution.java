package mergeksortedlists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
 
 class Solution {

      // Approach 1 - Combine each linkedlist's element's value into an AL
      // sort the AL, and create a new LL from the AL and return it
      // Time - O(n logn) for sort, Space - O(n) for the auxiliary list
      ListNode mergeKLists(ListNode[] lists) {
         List<Integer> list = new ArrayList<>();
         for(ListNode l: lists) {
             ListNode curr = l;
             while(curr != null) {
                 list.add(curr.val);
                 curr = curr.next;
             }
         }
         list.sort(Comparator.naturalOrder());
         ListNode current = null, head = current;
         Iterator<Integer> iter = list.iterator();
         while (iter.hasNext()) {
             int v = iter.next();
             if(current == null) {
                 current = new ListNode(v);
                 head = current;
             }
             else {
                 current.next = new ListNode(v);
                 current = current.next;
             }

         }
         return head;

     }
}
