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
    public ListNode reverseList(ListNode head) {
        //lets do it by recursion
        
        if(head==null||head.next==null) return head;
        
        ListNode curr=head;
        ListNode recRes=reverseList(head.next);
        curr.next.next=curr;
        curr.next=null;
        return recRes;
    }
}