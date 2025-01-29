class Solution {
    public int solve(int cr, int cc, int r, int c, int[][] matrix, int[][] dp) {
        // Base case: When you reach the last row, return the value at matrix[cr][cc]
        if (cr == r - 1) {
            return matrix[cr][cc];
        }

        // If this subproblem has been solved already, return the stored result
        if (dp[cr][cc] != -100000) {
            return dp[cr][cc];
        }

        int f = Integer.MAX_VALUE; // Left diagonal
        int s = Integer.MAX_VALUE; // Down
        int t = Integer.MAX_VALUE; // Right diagonal

        // Move to the left diagonal if possible
        if (cc - 1 >= 0) {
            f = solve(cr + 1, cc - 1, r, c, matrix, dp);
        }

        // Move straight down
        s = solve(cr + 1, cc, r, c, matrix, dp);

        // Move to the right diagonal if possible
        if (cc + 1 < c) {
            t = solve(cr + 1, cc + 1, r, c, matrix, dp);
        }

        // Store the result in dp array to avoid redundant calculations
        return dp[cr][cc] = matrix[cr][cc] + Math.min(f, Math.min(s, t));
    }

    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int min = Integer.MAX_VALUE;

        // Create a dp array and initialize it with -1
        int[][] dp = new int[row][col];
        for (int[] r1 : dp) {
            Arrays.fill(r1, -100000);
        }

        // Try every starting point in the first row and calculate the minimum path sum
        for (int i = 0; i < col; i++) {
            min = Math.min(min, solve(0, i, row, col, matrix, dp));
        }

        return min;
    }
}
