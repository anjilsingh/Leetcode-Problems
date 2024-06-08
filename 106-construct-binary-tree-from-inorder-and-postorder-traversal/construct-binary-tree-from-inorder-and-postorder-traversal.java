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

import java.util.HashMap;
import java.util.Map;
 
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     Map<Integer, Integer> inmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inmap);
    }

    private TreeNode buildTree(int[] postor, int postSt, int postEnd, int[] inor, int inSt, int inEnd, Map<Integer, Integer> inmap) {
        if (postSt > postEnd || inSt > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postor[postEnd]);
        int inroot = inmap.get(root.val);
        int numsLeft = inroot - inSt;

        root.left = buildTree(postor, postSt, postSt + numsLeft-1, inor, inSt, inroot - 1, inmap);
        root.right = buildTree(postor, postSt + numsLeft , postEnd-1, inor, inroot + 1, inEnd, inmap);

        return root;
    }
}
