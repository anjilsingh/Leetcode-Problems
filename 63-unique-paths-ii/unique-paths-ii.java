class Solution {
    public int solve(int i, int j, int m, int n, int[][] dp, int[][] obstacleGrid) {
        // Base case: If we reach the bottom-right corner, return 1 if not an obstacle
        if (i == m - 1 && j == n - 1) {
            return obstacleGrid[i][j] == 1 ? 0 : 1;
        }
        
        // If out of bounds or the current cell is an obstacle, return 0
        if (i >= m || j >= n || obstacleGrid[i][j] == 1) {
            return 0;
        }
        
        // If the current state has already been computed, return its value
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        // Recursive calls for moving down and right
        return dp[i][j] = solve(i + 1, j, m, n, dp, obstacleGrid) + solve(i, j + 1, m, n, dp, obstacleGrid);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // If the starting cell is an obstacle, no paths are possible
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        // Declare and initialize the dp array with -1
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        // Start recursion from the top-left corner
        return solve(0, 0, m, n, dp, obstacleGrid);
    }
}
