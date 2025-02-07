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

        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode secHead=slow.next;
        slow.next=null;

        //now reverse the sec ll

        ListNode curr=secHead;
        ListNode prev=null;
        while(curr!=null){
         ListNode currNext=curr.next;
         curr.next=prev;
         prev=curr;
         curr=currNext;
        }

        ListNode fH=head;
        ListNode sH=prev;

        while(sH!=null){
            ListNode fHNext=fH.next;
            ListNode sHNext=sH.next;

            fH.next=sH;
            sH.next=fHNext;
            fH=fHNext;
            sH=sHNext;
        }
      //  return head;
    }
}