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
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }
        return prev;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Reverse the linked list
        ListNode rev = reverse(head);

        // Special case: removing the first node of the reversed list (nth from end)
        if (n == 1) {
            return reverse(rev.next); // Remove the first node and reverse back
        }

        // Traverse to the (n-1)th node in the reversed list
        ListNode temp = rev;
        for (int i = 0; i < n - 2; i++) { // (n-2) iterations to reach (n-1)th node
            temp = temp.next;
        }

        // Remove the nth node by skipping it
        temp.next = temp.next.next;

        // Reverse the list back and return
        return reverse(rev);
    }
}
