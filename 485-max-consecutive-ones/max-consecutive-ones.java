class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_count=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
              count++;
            }
            
            if(nums[i]==0){
               max_count=Math.max(max_count,count);
               count=0;
            }
        }
        return Math.max(max_count,count);
    }
}