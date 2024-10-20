class Solution {
    public int solve(int n, int i, int[] nums,int[] dp) {
        // Base case: If we've gone beyond the array length, return 0
        if (i >= n) {
            return 0;
        }

        // Recursive case: Either take the current element and move to i+2, or skip the current element
        if(dp[i]!=-1){
            return dp[i];
        }
        int max_amount = Math.max(nums[i] + solve(n, i + 2, nums,dp), solve(n, i + 1, nums,dp));

        return dp[i]=max_amount;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        // Edge case: If there are no houses, return 0
        if (n == 0) {
            return 0;
        }
        int[] dp=new int[n];
        Arrays.fill(dp,-1);

        // Start solving from the first house
        return solve(n, 0, nums,dp);
    }
}
