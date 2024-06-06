/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private void markParents(TreeNode root,Map<TreeNode,TreeNode>parent_track,TreeNode target){
      Queue<TreeNode>q=new LinkedList<>();
      q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left!=null){
         parent_track.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
 parent_track.put(curr.right,curr);
                q.offer(curr.right);
            }
        
        
        }
    }
    
    
    
    //  private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track, TreeNode target) {
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     while(!queue.isEmpty()) {
    //         TreeNode current = queue.poll();
    //         if(current.left != null) {
    //             parent_track.put(current.left, current);
    //             queue.offer(current.left);
    //         }
    //         if(current.right != null) {
    //             parent_track.put(current.right, current);
    //             queue.offer(current.right);
    //         }
    //     }
    // }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
         Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track, target);  // Track the parent of each node
        
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        
        // BFS to find all nodes at distance K
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(curr_level == k) break;  // Stop if we have reached the desired level
            curr_level++;
            
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if(current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null) {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        
        // Collecting all nodes at distance K
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        
        return result;
    }
}