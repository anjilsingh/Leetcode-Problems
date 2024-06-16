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
class BSTIterator {
    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        pushLeft(st, root);
    }

    private void pushLeft(Stack<TreeNode> st, TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = st.pop();
        int res = node.val;
        if (node.right != null) {
            pushLeft(st, node.right);
        }
        return res;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */