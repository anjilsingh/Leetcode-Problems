class Solution {
    public int solve(int[] nums,int i,int[] dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        return dp[i]=Math.max(nums[i]+solve(nums,i+2, dp),solve(nums,i+1,dp));
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(nums,0,dp);
    }
}