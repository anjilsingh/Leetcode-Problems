class Solution {
    int[][] dp;

    public int solve(int[] coins, int i, int n, int amount, int sum, int[][] dp) {
        // If the sum exceeds the amount or we're out of bounds
        if (sum == amount) {
            return 0; // Found a valid combination, no more coins needed
        }
        if (sum > amount || i == n) {
            return Integer.MAX_VALUE; // Exceeds the amount or no more coins to try
        }

        // Ensure the sum is within bounds
        if (sum < 0 || sum > amount) {
            return Integer.MAX_VALUE;
        }

        // If this state has already been computed, return the stored result
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }

        // Include the current coin and move forward
        int include = solve(coins, i, n, amount, sum + coins[i], dp);

        // Exclude the current coin and move to the next one
        int exclude = solve(coins, i + 1, n, amount, sum, dp);

        // Store the result in the dp array for future reference
        dp[i][sum] = Math.min(include == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + include, exclude);

        return dp[i][sum];
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        // Initialize the dp matrix with -1 (indicating uncomputed results)
        dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;  // Marking as uncomputed initially
            }
        }

        int result = solve(coins, 0, n, amount, 0, dp);
        return result == Integer.MAX_VALUE ? -1 : result; // If no solution, return -1
    }
}
