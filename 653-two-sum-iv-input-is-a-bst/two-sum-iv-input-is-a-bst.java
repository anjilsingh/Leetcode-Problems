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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer>in=new ArrayList<>();
        inTrav(in,root);
        return got(in,k);
        
    }
    private static void inTrav(ArrayList<Integer>in,TreeNode root){
        if(root==null){
          return;
        }
        inTrav(in,root.left);
        in.add(root.val);
        inTrav(in,root.right);
        
    }
    private static boolean got(ArrayList<Integer>in,int k){
       int ptr1=0;
       int ptr2=in.size()-1;
       while(ptr1<ptr2){
         if((in.get(ptr1)+in.get(ptr2))==k){
             return true;
         } 
          else if((in.get(ptr1)+in.get(ptr2))<k){
            ptr1++;
          }
           else{
            ptr2--;
           }
       
       }
        return false;
    }
}