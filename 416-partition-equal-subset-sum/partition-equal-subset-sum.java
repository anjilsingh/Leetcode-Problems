class Solution {
    public boolean solve(int[] nums, int n, int target,Boolean[][] dp){
        if(target==0) return true;
        if(n==0) return false;
        if(dp[n][target]!=null){
            return dp[n][target];
        }
        if(nums[n-1]<=target){
            return dp[n][target]= solve(nums,n-1,target-nums[n-1],dp)||solve(nums,n-1,target,dp);
        }
        else{
            return dp[n][target]= solve(nums,n-1,target,dp);
        }
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        
        if(sum%2==0){
            Boolean[][] dp=new Boolean[n+1][sum+1];
            return solve(nums,n,sum/2,dp);
        }
        else{
            return false;
        }
    }
}