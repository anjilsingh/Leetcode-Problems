class Solution {
   
    public int climbStairs(int n) {
     // int[] dp=new int[n+1];
     // dp[n]=1;
     // dp[n-1]=1;
        
     int prev2=1;
     int prev1=1;
     
     for(int i=n-2;i>=0;i--){
         int curr=prev2+prev1;
         prev2=prev1;
         prev1=curr;
         //dp[i]=dp[i+1]+dp[i+2];
     }
     return prev1;
      
    }
}