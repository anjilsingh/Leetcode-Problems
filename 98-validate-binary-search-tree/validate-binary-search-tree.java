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
    public boolean isVal(TreeNode root,long lb,long rb){
        if(root==null) return true;
        if(root.val>=rb ||root.val<=lb) return false;
        return (isVal(root.left,lb,root.val) && isVal(root.right,root.val,rb));
    }
    public boolean isValidBST(TreeNode root) {
       return isVal(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}