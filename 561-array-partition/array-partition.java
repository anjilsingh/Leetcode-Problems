class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int max_sum=0;
        for(int i=0;i<nums.length;i=i+2){
            max_sum=max_sum+nums[i];
        }
        return max_sum;
    }
}