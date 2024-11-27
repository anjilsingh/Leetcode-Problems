class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
       int res=nums[0];
        while(left<=right){
            
            if(left<=right){
            res=Math.min(res,nums[left]);
            }
            int mid=(left+right)/2;
            res=Math.min(res,nums[mid]);
            if(nums[left]<=nums[mid]){
             left=mid+1;
            }
            else{
               right=mid-1;
            }

        }
        return res;
    }
}