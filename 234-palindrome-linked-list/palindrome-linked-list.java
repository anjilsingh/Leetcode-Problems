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
    
    public ListNode findMiddle(ListNode head){
      ListNode slow=head;
      ListNode fast=head.next.next;
     while(fast!=null && fast.next!=null){
           fast=fast.next.next;
           slow=slow.next;
     }
        return slow;
    }
    
    public ListNode findReverse(ListNode head){
        //by using recursion
        if(head==null ||head.next==null){
           return head;
        }
        ListNode rec=findReverse(head.next);
        head.next.next=head;
        head.next=null;
        return rec;
        
    
    
    }
    
    
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle=findMiddle(head);
        ListNode revHead=findReverse(middle.next);
        
        //Now check in both 
        ListNode fstart=head;
        ListNode sstart=revHead;
        
        while(sstart!=null){
            if(fstart.val!=sstart.val){
              findReverse(revHead);
               return false;
              
            }
            fstart=fstart.next;
            sstart=sstart.next;
            
        }
        
        findReverse(revHead);
        return true;

        
    }
}
