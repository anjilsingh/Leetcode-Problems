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
    public void reorderList(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

        }
        ListNode sec=slow.next;
        slow.next=null;

        ListNode prev=null;
        ListNode curr=sec;

        while(curr!=null){
            ListNode currNext=curr.next;
            curr.next=prev;
            prev=curr;
            curr=currNext;
        }

        ListNode fHead=head;
        ListNode sHead=prev;

        while(sHead!=null){
            ListNode fhn=fHead.next;
            ListNode shn=sHead.next;

            fHead.next=sHead;
            sHead.next=fhn;
            fHead=fhn;
            sHead=shn;
        }
      //  return head;
    }
}