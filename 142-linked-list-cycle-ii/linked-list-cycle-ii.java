/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null ||head.next==null){
          return null;
        }
        ListNode temp=head;
        HashMap<ListNode,Integer>mp=new HashMap<>();
        
      while(temp.next!=null){
         if(!mp.containsKey(temp)){
            mp.put(temp,1);
         }
        else{
            return temp;
        
        }
          temp=temp.next;
        
        }
        return null;
    }
}