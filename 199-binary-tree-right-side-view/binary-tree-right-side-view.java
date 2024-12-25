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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
              int lSize=q.size();
              int rMost=-1;
              for(int i=0;i<lSize;i++){
                 TreeNode node=q.poll();
                 rMost=node.val;
                  if(node.left!=null)  q.add(node.left);
                  if(node.right!=null) q.add(node.right);
                 
              }
            ans.add(rMost);
        }
        return ans;
    }
}