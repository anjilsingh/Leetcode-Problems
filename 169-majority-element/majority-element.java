class Solution {
    public int majorityElement(int[] nums) {
      Arrays.sort(nums);
    if(nums.length==1){
      return nums[0];
    }
      int count=1;
      int ans=0;
      for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]==nums[i]){
                   count++;
                   if(count>nums.length/2){
                     
                      ans=nums[i];
                       count=0;
                   }
            }
          
      }
return ans;
    }
}