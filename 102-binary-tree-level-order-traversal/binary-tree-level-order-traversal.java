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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode>q=new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()){
            List<Integer>temp=new ArrayList<>();
            int size=q.size();
             for(int i=0;i<size;i++){
                 root=q.poll();
                 temp.add(root.val);
                if(root.left!=null){
                  q.add(root.left);
                }
                 if(root.right!=null){
                   q.add(root.right);
                 }
                
                 
             }
            
           ans.add(temp);
        }
        return ans;
    }
}