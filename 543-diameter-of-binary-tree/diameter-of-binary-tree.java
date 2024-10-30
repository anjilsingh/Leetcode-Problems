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
    int diameter=0;
    public int calculateHeight(TreeNode root){
        if(root==null) return 0;
        int lh=calculateHeight(root.left);
        int rh=calculateHeight(root.right);
        diameter=Math.max(diameter,lh+rh);
        return 1+Math.max(lh,rh);

    }
    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return diameter;
    }
}