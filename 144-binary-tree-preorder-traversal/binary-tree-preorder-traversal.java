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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        if(root==null){
            return pre;
        }
        Stack<TreeNode>st=new Stack<TreeNode>();
        st.push(root);
        while(!st.empty()){
            TreeNode node=st.pop();
            pre.add(node.val);
            if(node.right!=null){
                st.push(node.right);
            } 
            if(node.left!=null){
              st.push(node.left);
            }
        }
        return pre;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//         preorderHelper(root, pre);
//         return pre;
//     }

//     private void preorderHelper(TreeNode node, List<Integer> pre) {
//         if (node == null) {
//             return;
//         }
//         pre.add(node.val);          // Visit the root node
//         preorderHelper(node.left, pre);  // Traverse left subtree
//         preorderHelper(node.right, pre); // Traverse right subtree
//     }
}
}