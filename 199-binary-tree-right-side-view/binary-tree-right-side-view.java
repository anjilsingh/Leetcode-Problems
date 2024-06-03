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
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        recRight(root, ans, 0);
        return ans;
    }

    private void recRight(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }

        // If this is the first node of this level
        if (level == res.size()) {
            res.add(root.val);
        }

        // Recurse for right subtree first, then left subtree
        recRight(root.right, res, level + 1);
        recRight(root.left, res, level + 1);
    }
}