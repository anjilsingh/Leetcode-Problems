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
        if(root==null){
                 return post;
        }
        Stack<TreeNode>st1=new Stack<TreeNode>();
        TreeNode cur=root;
        while((cur!=null)||(!st1.empty())){

           if(cur!=null){
               st1.push(cur);
               cur=cur.left;
           }
           else{
             TreeNode temp=st1.peek().right;
              if(temp==null){
                  temp=st1.pop();
                  post.add(temp.val);
                  while(!st1.empty() && temp==st1.peek().right){
                      temp=st1.pop();
                      post.add(temp.val);
                  }
              
              
              }
               else{
                        cur=temp;
               }
           }
        
        }
              
              return post;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//         Stack<TreeNode>st2=new Stack<TreeNode>();
//           if (root == null) {
//             return post;
//         }
//         st1.push(root);
//         while(!st1.empty()){
//             TreeNode node=st1.pop();
//             st2.add(node);
//            if(node.left!=null) st1.add(node.left);
//            if(node.right!=null) st1.add(node.right);
            
//         }
//         while(!st2.empty()){
//           TreeNode n=st2.pop();
//             post.add(n.val);
            
//         }
        
//         return post;
        
//         postHelper(root,post);
//         return post;
        
//     }
//     private static void postHelper(TreeNode root,List<Integer>list){
//    if(root==null){
//      return ;
//    }
//         postHelper(root.left,list);
//         postHelper(root.right,list);
//         list.add(root.val);
    }
}