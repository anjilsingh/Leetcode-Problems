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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true; // Both trees are null, they are the same
        if (p == null || q == null) return false; // One tree is null, the other is not
        return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true; // An empty tree is a subtree of any tree
        if (root == null) return false;  // A non-empty subtree cannot be in a null tree
        if (isSameTree(root, subRoot)) return true; // Check if the current tree matches
        // Recursively check the left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
