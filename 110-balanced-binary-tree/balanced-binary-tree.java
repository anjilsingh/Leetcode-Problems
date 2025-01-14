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
 import java.util.*;
class Solution {
    public int gH(TreeNode root){
        if(root==null){
            return 0;
        }
        int lH=gH(root.left);
        int rH=gH(root.right);
        if(Math.abs(lH-rH)>1){
            return -1;
        }
        return 1+Math.max(lH,rH);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int lh=gH(root.left);
        if(lh==-1) return false;
        int rh=gH(root.right);
        if(rh==-1) return false;

        if(Math.abs(lh-rh)>1) return false;

        return (isBalanced(root.left) && isBalanced(root.right));
    }
}