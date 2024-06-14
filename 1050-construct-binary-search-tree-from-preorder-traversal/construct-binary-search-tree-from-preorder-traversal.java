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
import java.util.*;
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
   int[] inorder = preorder.clone(); // create a copy of the preorder array
Arrays.sort(inorder); 
          Map<Integer, Integer> inmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inmap);
        
    }
    
    
    private TreeNode buildTree(int[] preor, int preSt, int preEnd, int[] inor, int inSt, int inEnd, Map<Integer, Integer> inmap) {
        if (preSt > preEnd || inSt > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preor[preSt]);
        int inroot = inmap.get(root.val);
        int numsLeft = inroot - inSt;

        root.left = buildTree(preor, preSt + 1, preSt + numsLeft, inor, inSt, inroot - 1, inmap);
        root.right = buildTree(preor, preSt + numsLeft + 1, preEnd, inor, inroot + 1, inEnd, inmap);

        return root;
    }
}