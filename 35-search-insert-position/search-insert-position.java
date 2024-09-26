class Solution {
    public int searchInsert(int[] nums, int target) {
       
        int index=-1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
          int mid=(low+high)/2;
          if(nums[mid]==target){
             return mid;
          }
        else if(nums[mid]>target){
             high=mid-1;
        }
       else
       {    index=mid;
            low=mid+1;
       }
        }
        return index+1;
    }
}