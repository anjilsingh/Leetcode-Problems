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
    public void pre(TreeNode root,List<Integer>ans){
        if(root==null) return;
        Stack<TreeNode>st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node=st.pop();
            ans.add(node.val);
              if(node.right!=null){
              st.add(node.right);
            }
            if(node.left!=null){
               st.add(node.left);
            }
            
          

        }
    
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        pre(root,ans);
        return ans;
    }
}