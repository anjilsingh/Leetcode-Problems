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
    
    // Reverse a linked list
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode recNode = reverse(head.next);  // Reverse the rest of the list
        head.next.next = head;  // Make the next node point to the current node
        head.next = null;  // Set the current node's next to null (tail)
        return recNode;  // Return new head of the reversed list
    }

    // Check if the list is a palindrome
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Reverse a copy of the list
        ListNode reversedHead = reverse(cloneList(head));

        // Step 2: Compare original and reversed lists
        ListNode original = head;
        ListNode reversed = reversedHead;

        while (original != null && reversed != null) {
            if (original.val != reversed.val) {  // Compare node values
                return false;  // If values are different, it's not a palindrome
            }
            original = original.next;
            reversed = reversed.next;
        }
        
        return true;  // If all values matched, it's a palindrome
    }

    // Helper method to clone a list (to avoid modifying the original list)
    public ListNode cloneList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(head.val);  // Create a new node with the same value
        ListNode current = newHead;
        ListNode original = head.next;

        while (original != null) {
            current.next = new ListNode(original.val);  // Copy the value of each node
            current = current.next;
            original = original.next;
        }

        return newHead;  // Return the head of the cloned list
    }
}
