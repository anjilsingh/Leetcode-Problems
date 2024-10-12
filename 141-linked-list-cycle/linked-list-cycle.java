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
import java.util.HashMap;
public class Solution {
    public boolean hasCycle(ListNode head) {
      if(head==null ||head.next==null){
          return false;
        }
        ListNode temp=head;
        HashMap<ListNode,Integer>mp=new HashMap<>();
        
      while(temp.next!=null){
         if(!mp.containsKey(temp)){
            mp.put(temp,1);
         }
        else{
            return true;
        
        }
          temp=temp.next;
        
        }
        return false;
    }
}