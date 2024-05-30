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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>post=new ArrayList<>();
        postHelper(root,post);
        return post;
        
    }
    private static void postHelper(TreeNode root,List<Integer>list){
   if(root==null){
     return ;
   }
        postHelper(root.left,list);
        postHelper(root.right,list);
        list.add(root.val);
    }
}