class Solution {
    public boolean containsDuplicate(int[] nums) {

        //second approach sorting 
     //  time complexiety - o(log n)
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }
}