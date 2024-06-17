/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode first;
    private TreeNode firstNext;
    private TreeNode last;
    private TreeNode previousNode;

    public void recoverTree(TreeNode root) {
        first = firstNext = last = null;
        previousNode = new TreeNode(Integer.MIN_VALUE);
        inorderTraversal(root);

        if (first != null && last != null) {
            // Swap the values of the nodes that need to be corrected
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && firstNext != null) {
            // If the last node is not found, swap the first node with its next node
            int temp = first.val;
            first.val = firstNext.val;
            firstNext.val = temp;
        }
    }

    private void inorderTraversal(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                // Process current node as there is no left subtree
                if (previousNode != null && current.val < previousNode.val) {
                    if (first == null) {
                        first = previousNode;
                        firstNext = current;
                    } else {
                        last = current;
                    }
                }
                previousNode = current;
                current = current.right;
            } else {
                // Find the predecessor of current
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Create a temporary link to current
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // Restore the tree and process current node
                    predecessor.right = null;
                    if (previousNode != null && current.val < previousNode.val) {
                        if (first == null) {
                            first = previousNode;
                            firstNext = current;
                        } else {
                            last = current;
                        }
                    }
                    previousNode = current;
                    current = current.right;
                }
            }
        }
    }
}
