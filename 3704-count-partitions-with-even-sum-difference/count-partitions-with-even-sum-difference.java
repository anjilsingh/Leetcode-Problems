class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int count=0;
        int leftSum=0;
        for(int i=0;i<n-1;i++){
            leftSum+=nums[i];
            int rightSum=sum-leftSum;

            if(Math.abs(leftSum-rightSum)%2==0){
                count++;
            }
        }
        return count;
    }
}