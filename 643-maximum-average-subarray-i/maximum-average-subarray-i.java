class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //by using sliding window control method 
        int sum=0;
        double avg=Integer.MIN_VALUE;
        int j=0;
        
        for(int i=0;i<nums.length;i++){
           sum=sum+nums[i];
           if(i>=k-1){
               avg=Math.max(avg,(double)sum/k);
               sum=sum-nums[j];
               j++;
           }
        }
       return avg; 
    }
}