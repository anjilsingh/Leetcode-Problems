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
    public static int findHeight(TreeNode root){
        if(root==null) return 0;
        int lh=findHeight(root.left);
        int rh=findHeight(root.right);
        return 1+Math.max(lh,rh);

    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int lh=findHeight(root.left);
        int rh=findHeight(root.right);
        if(isBalanced(root.left) && isBalanced(root.right)&& Math.abs(lh-rh)<=1){
           return true;
        }
        return false;
    }
}