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
    public int findSum(int[] maxi,TreeNode root){
        if(root==null) return 0;
        int lSum=Math.max(findSum(maxi,root.left),0);
        int rSum=Math.max(findSum(maxi,root.right),0);
        maxi[0]=Math.max(maxi[0],lSum+rSum+root.val);

        return (root.val+Math.max(lSum,rSum));
    }
    public int maxPathSum(TreeNode root) {
        int maxi[]=new int[1];
        maxi[0]=Integer.MIN_VALUE;
        findSum(maxi,root);
        return maxi[0];
        
    }
}