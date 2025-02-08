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
    public int getHeight(TreeNode root)
    {
        if(root==null){
            return 0;
        }
        int lH=getHeight(root.left);
        int rH=getHeight(root.right);
        if(Math.abs(lH-rH)>1){
            return -1;
        }
        return 1+Math.max(lH,rH);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;

        int lH=getHeight(root.left);
        if(lH==-1){
            return false;
        }
        int rH=getHeight(root.right);
        if(rH==-1){
            return false;
        }
        if(Math.abs(lH-rH)>1){
            return false;
        }

        return (isBalanced(root.left) && isBalanced(root.right));
    }
}