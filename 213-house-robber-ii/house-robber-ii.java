class Solution {
    public int solve(int[] nums ,int i, int n, int[] dp){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        return dp[i]=Math.max(nums[i]+solve(nums,i+2,n,dp),solve(nums,i+1,n,dp));
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int[] dp1=new int[n];
        Arrays.fill(dp1,-1);
        return Math.max(solve(nums,0,n-1,dp),solve(nums,1,n,dp1));
    }
}