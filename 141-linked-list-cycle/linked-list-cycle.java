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
    public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false; // No cycle
    return hasCycle(head, head.next); // Start the recursion
}

public boolean hasCycle(ListNode slow, ListNode fast) {
    // Base cases
    if (fast == null || fast.next == null) return false; // No cycle
    if (slow == fast) return true; // Cycle detected

    // Recursive call with updated pointers
    return hasCycle(slow.next, fast.next.next);
}
}