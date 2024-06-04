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



class Pair<U, V> {
    private U key;
    private V value;
    
    public Pair(U key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public U getKey() { return key; }
    public V getValue() { return value; }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<Pair<TreeNode, Long>> q = new LinkedList<>();
        int ans = 0;
        q.add(new Pair<>(root, 0L));
        
        while (!q.isEmpty()) {
            int size = q.size();
            long mmin = q.peek().getValue();
            long first = 0, last = 0;
            
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Long> pair = q.poll();
                long curr_id = pair.getValue() - mmin;
                TreeNode node = pair.getKey();
                
                if (i == 0) {
                    first = curr_id;
                }
                if (i == size - 1) {
                    last = curr_id;
                }
                
                if (node.left != null) {
                    q.add(new Pair<>(node.left, 2 * curr_id + 1));
                }
                if (node.right != null) {
                    q.add(new Pair<>(node.right, 2 * curr_id + 2));
                }
            }
            
            ans = Math.max(ans, (int) (last - first + 1));
        }
        
        return ans;
    }
}
