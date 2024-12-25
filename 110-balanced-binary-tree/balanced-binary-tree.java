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
    public int getHt(TreeNode root){
        if(root==null) return 0;
        int lt=getHt(root.left);
        if(lt==-1) return -1;
        int rt=getHt(root.right);
        if(rt==-1) return -1;
        
        int ht=Math.abs(lt-rt);
        if(ht>1) return-1;
        else return 1+Math.max(lt,rt);
    }
    public boolean isBalanced(TreeNode root) {
      
        int ht=getHt(root);
        return (ht!=-1);
    }
}