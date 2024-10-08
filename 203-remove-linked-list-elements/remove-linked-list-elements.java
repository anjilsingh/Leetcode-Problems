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
    public ListNode removeElements(ListNode head, int val) {
        // Base case: if the list is empty, return null
        if (head == null) {
            return null;
        }

        // Recursively call the function on the next node
        head.next = removeElements(head.next, val);

        // If current node's value equals `val`, skip this node
        if (head.val == val) {
            return head.next;  // Skip the current node
        } else {
            return head;  // Keep the current node
        }
    }
}
