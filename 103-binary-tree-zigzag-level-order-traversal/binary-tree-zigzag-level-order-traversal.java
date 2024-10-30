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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true; // true means left-to-right, false means right-to-left

        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                // Simply add values to `temp`
                temp.add(node.val);
                
                // Add children to queue
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            // Reverse `temp` if flag is false for right-to-left order
            if (!flag) {
                Collections.reverse(temp);
            }
            
            ans.add(temp);
            flag = !flag; // Toggle flag for next level
        }

        return ans;
    }
}
