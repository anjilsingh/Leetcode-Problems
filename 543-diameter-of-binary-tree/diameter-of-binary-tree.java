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
    public int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dia(root);
        return diameter;
       
    }
    
    public int dia(TreeNode root){
          if(root==null) return 0;
        int leftMax=dia(root.left);
        int rMax=dia(root.right);
        if(leftMax+rMax>diameter){
               diameter=leftMax+rMax;
        }
        return 1+Math.max(leftMax,rMax);
    }
}