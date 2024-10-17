class Solution {
    
      static Boolean isSubsetSum(int N, int arr[], int sum){
       boolean[][] dp=new boolean[N+1][sum+1];
       //base cases
       //if sum==0 true
       //if n==0 return false 
 //apart from this we have two options either to inlcude or 
 //not and if the value is greater then summ then only not include
 
      for(int i=0;i<=N;i++){
          for(int j=0;j<=sum;j++){
              if(i==0 && j==0){
                  dp[i][j]=true;
              }
              else if(i==0){
                dp[i][j] =false;
              }
              else if(j==0){
                  dp[i][j]=true;
              }
              else{
                  if(arr[i-1]>j){
                      dp[i][j]=dp[i-1][j];
                  }
                  else{
                      dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
                  }
              }
              
          }
      }
      return dp[N][sum];
       
    }
    
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2==0){
           return isSubsetSum(n,nums,sum/2);
        }
        
        return false;
    }
}