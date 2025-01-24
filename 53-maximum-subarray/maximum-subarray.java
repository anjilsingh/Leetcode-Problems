class Solution {
    public int maxSubArray(int[] nums) {
        int mAns=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
           sum+=nums[i];
           mAns=Math.max(mAns,sum);
           if(sum<0){
            sum=0;
           }
        }
        return mAns;
    }
}