import java.util.Arrays;
import java.util.PriorityQueue;


class Solution {
    // Directions for moving up, down, left, and right
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n; // Dimensions of the grid
    int[][] grid; // Input grid
    int[][] dp; // Array to store the minimum obstacles to reach each cell

    public int minimumObstacles(int[][] grid) {
        // Initialize grid dimensions
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;

        // Initialize the dp array with a large value representing unvisited cells
        dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE); 
        }

        // Using Dijkstra's Algorithm to find the path with the minimum obstacles
        dp[0][0] = grid[0][0]; // Starting cell; its value determines if it starts with an obstacle
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); 
        // Priority queue to explore cells with the least obstacles first
        pq.add(new int[]{0, 0, dp[0][0]}); // Start from the top-left corner

        while (!pq.isEmpty()) {
            // Poll the cell with the least obstacles encountered so far
            int[] curr = pq.poll();
            int obs = curr[2], row = curr[0], col = curr[1];

            // If we reach the bottom-right corner, return the obstacle count
            if (row == m - 1 && col == n - 1) {
                return obs;
            }

            // Explore all possible directions
            for (int[] d : dir) {
                int r = row + d[0], c = col + d[1];

                // Skip invalid or out-of-bound cells
                if (!isValid(grid, r, c)) continue;

                // Calculate the number of obstacles if moving to the next cell
                int newobs = obs + grid[r][c];

                // If the new path has fewer obstacles than previously recorded, update dp and add to queue
                if (newobs < dp[r][c]) {
                    dp[r][c] = newobs;
                    pq.add(new int[]{r, c, newobs});
                }
            }
        }

        // If no path is found (though this should not happen in a connected grid)
        return dp[m - 1][n - 1];
    }

    // Helper method to check if a cell is valid (within bounds of the grid)
    private boolean isValid(int[][] grid, int row, int col) {
        return (
            row >= 0 && col >= 0 && row < grid.length && col < grid[0].length
        );
    }
}
