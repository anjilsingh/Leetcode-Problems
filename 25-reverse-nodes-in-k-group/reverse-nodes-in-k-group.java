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
    public ListNode getKth(ListNode gP,int k){
        while(gP!=null && k>0){
            gP=gP.next;
            k--;
        }
        return gP;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
          if(head==null ||k<=1){
              return head;
          }
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode gP=dummy;


        

          while(true){
            ListNode kth=getKth( gP,k);
             if (kth == null) { // Not enough nodes left
                break;
            }
            ListNode gN=kth.next;

            ListNode prev=null;
            ListNode curr=gP.next;
            while(curr!=gN){
                ListNode currNext=curr.next;
                curr.next=prev;
                prev=curr;
                curr=currNext;
            }

            ListNode temp=gP.next;
            gP.next=kth;
            temp.next=gN;
            gP=temp;
          
        }
        return dummy.next;
    }
}