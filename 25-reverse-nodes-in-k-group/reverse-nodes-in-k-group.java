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
    public ListNode getKth(ListNode node,int k){
       while(node!=null && k>0){
          node=node.next;
           k--;
       }
        return node;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head==null ||k<=1) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode gP=dummy;
        
        while(true){
            ListNode kth=getKth(gP,k);
            if(kth==null) break;
            ListNode gN=kth.next;
            
            
            ListNode curr=gP.next;
            ListNode prev=null;
            while(curr!=gN){
                ListNode currnext=curr.next;
                curr.next=prev;
                prev=curr;
                curr=currnext;
            }
            
            //now add gP with kth node and pNode first with second grop
            ListNode temp=gP.next;
            gP.next=kth;
            temp.next=gN;
            
            
            gP=temp;
        }
        return dummy.next;
    }
}