class Solution {
    public int removeDuplicates(int[] nums) {
        int l=0;
        for(int i=1;i<nums.length;i++){
         if(nums[l]<nums[i]){
             nums[l+1]=nums[i];
             l++;
         }
        
     }
        return l+1;
        
    }
}