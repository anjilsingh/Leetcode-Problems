class Solution {
       public static int perfectSum(int arr[], int n, int sum) {
        int[][] dp = new int[n+1][sum+1];
        
         int MOD = 1000000007;


    // Initialization
    for(int i = 0; i <= n; i++) {
        dp[i][0] = 1;  
    }
    for(int j = 1; j <= sum; j++) {
        dp[0][j] = 0;  
    }

    // Filling the DP table
    for(int i = 1; i <= n; i++) {
        for(int j = 0; j <= sum; j++) {
            if(arr[i-1] <= j) {
                dp[i][j] = (dp[i-1][j-arr[i-1]] + dp[i-1][j]) % MOD;
            } else {
                dp[i][j] = dp[i-1][j] % MOD;
            }
        }
    }

    int result = dp[n][sum];
    return result;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
       int sum=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        
        int s1=(sum+target)/2;
        if((sum+target)%2!=0 ||target>sum||target<-sum){
            return 0;
        }
        return perfectSum(nums,  n, s1);
    }
}