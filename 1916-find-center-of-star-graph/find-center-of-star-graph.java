class Solution {
    public int findCenter(int[][] edges) {
        // A star graph will have the same node appearing in both of the first two edges
        // The node that appears in both the first two edges is the center of the star graph
        
        // Check the first two edges
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }
    }
}
