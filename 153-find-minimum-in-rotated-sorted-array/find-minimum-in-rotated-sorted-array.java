class Solution {
    public int findMin(int[] nums) {
        int min=Integer.MAX_VALUE;
        int n=nums.length;

        int left=0;
        int right=n-1;

        while(left<=right){
            if(nums[left]<=nums[right]){
                min=Math.min(min,nums[left]);
                return min;
            }
            int mid=(left+right)/2;
            min=Math.min(min,nums[mid]);

            //left sorted part

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