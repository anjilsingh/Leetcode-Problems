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
    public int maxPathSum(TreeNode root) {
     int[] maxi = {Integer.MIN_VALUE};
        getMax(root,maxi);
        return maxi[0];
    }
    private static int getMax(TreeNode root,int maxi[]){
          if(root==null){
              return 0;
              
          }
        int leftSum=Math.max(0,getMax(root.left,maxi));
        int rightSum=Math.max(0,getMax(root.right,maxi));
        maxi[0]=Math.max(maxi[0],leftSum+rightSum+root.val);
        return Math.max(leftSum,rightSum)+root.val;
    
    
    }
}