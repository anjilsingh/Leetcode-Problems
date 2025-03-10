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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null) return ans;
        
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        boolean ltor=true;
        while(!q.isEmpty()){
          List<Integer>res=new ArrayList<>();
          int size=q.size();
          for(int i=0;i<size;i++){
              TreeNode node=q.poll();
              res.add(node.val);
              if(node.left!=null){
                q.add(node.left);
              }
              if(node.right!=null){
                    q.add(node.right);
              }
          }
            if(ltor) ans.add(res);
            
            else {
                Collections.reverse(res);
                ans.add(res);
                }
            ltor=!ltor;
        }
        return ans;
    }
}