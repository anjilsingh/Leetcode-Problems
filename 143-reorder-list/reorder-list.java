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
        //very easy guys 
        //first just find the middle value 
        //uhmmm simple fast and slow pointer appraoch
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        //now slow is our middle value so we will divide our ll in two parts 
        //one till slow
        //and other from slow to end
        
        
        ListNode sec=slow.next;
        slow.next=null;
        ListNode prev=null;
        //no i need to reverse the linkedlist starting from sec
        
        while(sec!=null){
            ListNode secnext=sec.next;
            sec.next=prev;
            prev=sec;
            sec=secnext;

        }
        
        //now prev is my second list head
        
        sec=prev;
        //no merge the list 
        ListNode first=head;
        while(sec!=null){
          ListNode temp1=first.next;
          ListNode temp2=sec.next;
          first.next=sec;
          sec.next=temp1;
          first=temp1;
          sec=temp2;

        }
        
        
    }
}