/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //two pass

        HashMap<Node,Node>mp=new HashMap<>();
        mp.put(null,null);
       Node curr=head;

        while(curr!=null){
        Node currCpy=new Node(curr.val);
          mp.put(curr,currCpy);
          curr=curr.next;
        }

        curr=head;

        while(curr!=null){
           mp.get(curr).next=mp.get(curr.next);
           mp.get(curr).random=mp.get(curr.random);
           curr=curr.next;
        }
        return mp.get(head);
    }
}