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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer>in=new ArrayList<>();
        inHelper(root,in);
        return in;
        
     
        
        
//           List<Integer> result = new ArrayList<>();
//         Stack<TreeNode> stack = new Stack<>();

//         while (root != null || !stack.isEmpty()) {
//             while (root != null) {
//                 stack.push(root);
//                 root = root.left;
//             }
//             root = stack.pop();
//             result.add(root.val);
//             root = root.right;
//         }

//         return result;
    }
    
    private static void  inHelper(TreeNode root,List<Integer>list){
        if(root==null){
 return;}
       inHelper(root.left,list);
    list.add(root.val);
        inHelper(root.right,list);
    }
}