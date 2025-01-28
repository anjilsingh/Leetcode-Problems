class Solution {
     public int robb(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        int[] dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            if(i==1){
                dp[i]=Math.max(nums[i],nums[i-1]);
            }
            else{
                dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
            }
        }
        return dp[n-1];
    }

    public int rob(int[] nums) {
        int n=nums.length;
        
           if (n == 1) {
            return nums[0];
        }
        int[] num1=new int[n-1];
        int[] num2=new int[n-1];
        for(int i=0;i<n-1;i++){
            num1[i]=nums[i+1];
            num2[i]=nums[i];
        }

        return Math.max(robb(num1),robb(num2));
    }
}