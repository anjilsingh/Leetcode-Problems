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
    public void good(TreeNode root,int maxSoFor,int[] count){
        if(root==null){
            return;
        }
        if(root.left!=null){
        if(root.left.val>=maxSoFor){
            count[0]++;
        }

        good(root.left,Math.max(maxSoFor,root.left.val),count);
        }
        if(root.right!=null){
        if(root.right.val>=maxSoFor){
            count[0]++;
        }
        good(root.right,Math.max(maxSoFor,root.right.val),count);
        }


    }
    public int goodNodes(TreeNode root) {
        int[] count={1};
        good(root,root.val,count);
        return count[0];
    }
}