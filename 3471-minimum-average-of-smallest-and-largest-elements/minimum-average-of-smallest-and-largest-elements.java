class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double ans=Integer.MAX_VALUE;
        int i=0;
        int j=nums.length-1;
        while(i<j){
            double avg=((double)nums[i]+nums[j])/2;
            ans=Math.min(ans,avg);
            i++;
            j--;
        }
        return ans;
    }
}