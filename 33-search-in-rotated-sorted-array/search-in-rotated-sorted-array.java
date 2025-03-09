class Solution {
    public int search(int[] nums, int target) {
        //we have to find the element in rotated sorted array 
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }

            //either in left soted part 
            if(nums[left]<=nums[mid]){
                if(target<nums[left] || target>nums[mid]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }

            

            //or in right sorted part 
            else{
                if(target>nums[right] || target<nums[mid]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
        }
        return -1;
    }
}