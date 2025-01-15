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
    int maxSum=Integer.MIN_VALUE;
    public int findSum(TreeNode root){
     if(root==null){
            return 0;
        }

        int leftSum=Math.max(findSum(root.left),0);
        int rightSum=Math.max(findSum(root.right),0);
        maxSum=Math.max(maxSum,root.val+leftSum+rightSum);
        return Math.max(leftSum+root.val,rightSum+root.val);
    }
    public int maxPathSum(TreeNode root) {
        findSum(root);
        return maxSum;
        
    }
}