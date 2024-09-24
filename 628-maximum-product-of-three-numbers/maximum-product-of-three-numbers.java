class Solution {
    public int maximumProduct(int[] nums) {
     
        // the approach is to find the 3 largest numbers and two smatllest numbers ans then finad the max among these products
        
       int fMax=Integer.MIN_VALUE;
       int sMax=Integer.MIN_VALUE;
       int tMax=Integer.MIN_VALUE;
       int fmin=Integer.MAX_VALUE;
       int smin=Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=fMax ){
             tMax=sMax;
             sMax=fMax;
             fMax=nums[i];
            }
            else if(nums[i]>sMax){
                 tMax=sMax;
                sMax=nums[i];
            }
            else if(nums[i]>tMax){
              tMax=nums[i];
            }
            
            if(nums[i]<fmin){
                 smin=fmin;
                fmin=nums[i];
                
            }
            else if(nums[i]<smin){
               smin=nums[i];
            }
        }
       return Math.max(fmin*smin*fMax,fMax*sMax*tMax);
    }
}