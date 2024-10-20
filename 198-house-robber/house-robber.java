class Solution {
    public int solve(int n,int i,int[] nums,int[]dp){
      if(i>=n){
          return 0;
      }
     if(dp[i]!=-1){
        return dp[i];
     }
     int ans=Math.max(nums[i]+solve(n,i+2,nums,dp),solve(n,i+1,nums,dp));
     return dp[i]=ans;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int ans=solve(n,0,nums,dp);
        return ans;
    }
}