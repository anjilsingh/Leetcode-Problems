class Solution {
    public boolean solve(int[] arr, int n, int target,Boolean[][] dp){
 
            for (int i = 0; i <= n; i++) {
            dp[i][0] = true;  // A subset sum of 0 is always possible
        }
        for (int j = 1; j <= target; j++) {
            dp[0][j] = false; // If no elements, no subset (except 0) is possible
        }
   


       for(int i=1;i<=n;i++){
        for(int j=1;j<=target;j++){
            if(arr[i-1]<=j){
                dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];
            }
            else{
                dp[i][j]=dp[i-1][j];
            }
        }
       }
       return dp[n][target];
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