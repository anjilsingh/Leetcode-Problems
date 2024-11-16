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
    public int isBal(TreeNode root){
         if(root==null){
           return 0;
         }
         int lmax=isBal(root.left);
         if(lmax==-1) return -1;
         int rmax=isBal(root.right);
        if(rmax==-1) return -1;
         if(Math.abs(lmax-rmax)>1) return -1;
         return 1+Math.max(lmax,rmax);
    } 
    public boolean isBalanced(TreeNode root) {
         if(isBal(root)==-1) return false;
        return true;
    }
}