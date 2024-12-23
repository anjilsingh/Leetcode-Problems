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
     //first find the middle of ll
     //then rev the sec list 
    //a snd then put one one 
        
        
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        
        ListNode sec=slow.next;
        slow.next=null;
        //rev the sec ll
        ListNode curr=sec;
        ListNode temp=null;
        ListNode prev=null;
        while(curr!=null){
           ListNode currNext=curr.next;
            curr.next=prev;
            prev=curr;
            curr=currNext;
        }
        
        ListNode secHead=prev;
        ListNode firstHead=head;
        
        while(secHead!=null){
            ListNode firstHeadnext=firstHead.next;
            ListNode secHeadnext=secHead.next;
            
            firstHead.next=secHead;
            secHead.next=firstHeadnext;
            firstHead=firstHeadnext;
            secHead=secHeadnext;
        }
          
    }
}