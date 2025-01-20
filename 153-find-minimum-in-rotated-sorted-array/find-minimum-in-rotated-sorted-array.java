class Solution {
    public int findMin(int[] nums) {
        int min=Integer.MAX_VALUE;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            min=Math.min(nums[mid],min);

            if(nums[left]<=nums[right]){
                min=Math.min(min,nums[left]);
                return min;
            }

            if(nums[left]<=nums[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
            
        }
        return min;
    }
}