class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1){

        return nums[0];
        }
        Arrays.sort(nums);
        int cnt=1;
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
          if(nums[i]==nums[i+1]){
               cnt++;
              if(cnt>nums.length/2){
                 ans=nums[i];
              }
          }
            else{
                  cnt=1;
            }
        }
        return ans;
    }
}