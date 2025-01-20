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

        //reverse the sec one
        ListNode prev=null;
        ListNode curr=sec;

        while(curr!=null){
            ListNode currNext=curr.next;
            curr.next=prev;
            prev=curr;
            curr=currNext;
        }
        ListNode sHead=prev;
        ListNode fhead=head;

        //second will always be samleer

        while(sHead!=null){
            ListNode fHeadNext=fhead.next;
            ListNode sHeadNext=sHead.next;

        fhead.next=sHead;
        sHead.next=fHeadNext;

        fhead=fHeadNext;
        sHead=sHeadNext;
        }

    }
}