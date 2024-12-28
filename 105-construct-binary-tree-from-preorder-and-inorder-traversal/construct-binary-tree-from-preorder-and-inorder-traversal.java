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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0) return null;

        int ele=preorder[0];
        int mid=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==ele){
              mid=i;
              break;

            }
        }
        TreeNode root=new TreeNode(ele);
        int[] leftPre=Arrays.copyOfRange(preorder,1,mid+1);
        int[] leftIn=Arrays.copyOfRange(inorder,0,mid);
        root.left=buildTree(leftPre,leftIn);

        int[] rPre=Arrays.copyOfRange(preorder,mid+1,preorder.length);
        int[] rIn=Arrays.copyOfRange(inorder,mid+1,inorder.length);
        root.right=buildTree(rPre,rIn);

        return root;
    }
}