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
        //first find the middle 
        //then second the sec 
        //and then merge

        ListNode slow=head;
        ListNode fast=head;
         
         while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
         }

         ListNode sec=slow.next;
         slow.next=null;

         //now rev the sec list 
         ListNode curr=sec;
         ListNode prev=null;
         while(curr!=null){
            ListNode currNext=curr.next;
            curr.next=prev;
            prev=curr;
            curr=currNext;
         }
         ListNode fHead=head;
         ListNode sHead=prev;
         while(sHead!=null){
            ListNode fNext=fHead.next;
            ListNode sNext=sHead.next;
            fHead.next=sHead;
            sHead.next=fNext;

            fHead=fNext;
            sHead=sNext;
         }
      
    }
}