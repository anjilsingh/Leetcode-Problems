class Solution {
    public void rev(int[] nums,int l,int r){
        while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
    public void rotate(int[] nums, int k) {
        //right rotate means 
        //first rev the n-k
        //then left k
        //then rev the whole
        
        int n=nums.length;
        k=k%n;
        rev(nums,0,n-k-1);
        rev(nums,n-k,n-1);
        rev(nums,0,n-1);
    }
}