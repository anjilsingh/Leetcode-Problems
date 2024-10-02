class Solution {
    public void moveZeroes(int[] nums) {
        int l=-1;
        for(int i=0;i<nums.length;i++){
           if(nums[i]==0){
              l=i;
              break;
           }
        }
        if(l==-1){
           return;
        }
        for(int i=l+1;i<nums.length;i++){
           if(nums[i]!=0){
              int temp=nums[i];
               nums[i]=nums[l];
               nums[l]=temp;
               l++;
           }
        }
  
    }
}