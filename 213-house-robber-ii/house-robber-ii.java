class Solution {
    public int robb(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp=new int[n];
        dp[0]=nums[0];
        //dp[1]=Math.max(dp[0],dp[1]);

        for(int i=1;i<n;i++){
            if(i==1){
                dp[i]=Math.max(nums[0],nums[1]);
            }
            else{
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
            }
        }
        return dp[n-1];
    }
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
         int[] skipFirst=new int[nums.length-1];
         int[] skipLast=new int[nums.length-1];

         for(int i=0;i<nums.length-1;i++){
            skipFirst[i]=nums[i+1];
            skipLast[i]=nums[i];
         }
         return Math.max(robb(skipFirst),robb(skipLast));
    }
}