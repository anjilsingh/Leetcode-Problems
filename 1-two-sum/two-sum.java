class Solution {
    public int[] twoSum(int[] nums, int target) {
        //can use two pointer but that is easy if we have to directly do for number
        for(int i=0;i<nums.length;i++){
          for(int j=i+1;j<nums.length;j++){
            if(nums[i]+nums[j]==target) return new int[]{i,j};
          }
        }
        return new int[]{-1,-1};
    }
}