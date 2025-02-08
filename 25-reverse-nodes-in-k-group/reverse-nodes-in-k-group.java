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
    public ListNode getKth(ListNode head,int k){
        while(head!=null && k>0){
            head=head.next;
            k--;
        }
        return head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null ||k<=1){
            return head;
        }
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode gp=dummy;

        while(true){
            ListNode kth=getKth(gp,k);
            if(kth==null) break;

            ListNode gN=kth.next;
            ListNode curr=gp.next;
            ListNode prev=null;

            while(curr!=gN){
               ListNode currnext=curr.next;
               curr.next=prev;
               prev=curr;
               curr=currnext;
            }

            ListNode temp=gp.next;
            gp.next=kth;
            temp.next=gN;
            gp=temp;
        }

        return dummy.next;
    }
}