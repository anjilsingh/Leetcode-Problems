class Solution {
    public boolean containsDuplicate(int[] nums) {
        //brute dorce approach
        // for(int i=0;i<nums.length;i++){
        //      for(int j=0;j<i;j++){
        //          if(nums[i]==nums[j]){
        //                 return true;
        //          }
        //      }
        // }
        // return false;
        
        ///better
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]) return true;
            }
        
        return false;
        
    }}