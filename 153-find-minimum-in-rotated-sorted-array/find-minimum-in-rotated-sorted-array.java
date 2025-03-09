class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int min=Integer.MAX_VALUE;
        while(left<=right){
            if(nums[left]<=nums[right]){
                min=Math.min(min,nums[left]);
                return min;
            }
            int mid=left+(right-left)/2;
            min=Math.min(min,nums[mid]);

            //left sorted part
             if(nums[left]<=nums[mid]){
                //means we need to move right
                left=mid+1;
             }
            //right sorted part
            else{
                right=mid-1;
            }

        }
        return min;
    }
}