class Solution {
    public int removeDuplicates(int[] nums) {
        int l=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]!=nums[l]){
              nums[l+1]=nums[i];
               l++;
           }
        }
        return l+1;
    }
}