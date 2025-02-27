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
    int max=Integer.MIN_VALUE;

    public int maxSum(TreeNode root){
        if(root==null) return 0;

        int lSum=Math.max(0,maxSum(root.left));
        int rSum=Math.max(0,maxSum(root.right));
        max=Math.max(max,root.val+lSum+rSum);
        return Math.max(root.val+lSum,root.val+rSum);
    }
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }
}