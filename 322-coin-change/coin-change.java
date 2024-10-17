class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        int infi = amount + 1;  // A safe value to represent "infinity"
        
        // Initialize the dp table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (i == 0) {
                    dp[i][j] = infi;  // If no coins, we can't make any amount except 0
                } else if (j == 0) {
                    dp[i][j] = 0;  // To make 0 amount, 0 coins are needed
                } else if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        // If the final result is still "infinity", that means it's impossible to make the amount
        return dp[n][amount] == infi ? -1 : dp[n][amount];
    }
}
