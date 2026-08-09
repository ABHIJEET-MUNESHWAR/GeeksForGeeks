/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {  
        
        ListNode iNode = head;
        ListNode jNode = head;
        while (n-- > 0) {
          iNode = iNode.next;
        }
        if (iNode == null) {
          return head.next;
        }
        while (iNode.next != null) {
          iNode = iNode.next;
          jNode = jNode.next;
        }
        jNode.next = jNode.next.next;
        return head;
    }
}