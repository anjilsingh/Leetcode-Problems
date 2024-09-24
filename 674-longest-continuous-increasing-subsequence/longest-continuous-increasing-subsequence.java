class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int count=1;
        for(int i=0;i<nums.length-1;i++){
             if(nums[i+1]>nums[i]){
                 count++;
                 ans=Math.max(count,ans);
             }
            else{
               count=1;
            }
        }
      return Math.max(count,ans);  
    }
}