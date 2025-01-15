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
    public static void  good(TreeNode root,int maxSoFor,int[] max){
        if(root==null){
            return ;
        }
        if(root.left!=null){
        if(root.left.val>=maxSoFor){
            max[0]++;
            
        }
        good(root.left,Math.max(root.left.val,maxSoFor),max);
        }
        if(root.right!=null){
        if(root.right.val>=maxSoFor){
            max[0]++;
           
        }
        good(root.right,Math.max(root.right.val,maxSoFor),max);
        }
    }
    public int goodNodes(TreeNode root) {
        int[] max=new int[1];
        max[0]=1;
        good(root,root.val,max);
        return max[0];

    }
}