class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int left=0;
        int right=n-1;
        while(left<=right){ 
            if(nums[left]<=nums[right]){
              min=Math.min(min,nums[left]);
              break;
          }
            
           int mid=(left+right)/2;
            min=Math.min(nums[mid],min);
            
           if(nums[left]<=nums[mid]){
             left=mid+1;
           }
           else if(nums[left]>nums[mid]){
                 right=mid-1;
          }
         
            
        }
        return min;
    }
}