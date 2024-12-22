class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        
        int l=0;
        int r=n-1;
        
        while(l<=r){
           if(nums[l]<=nums[r]){
             min=Math.min(nums[l],min);
             return min;
           }
            int mid=(l+r)/2;
            min=Math.min(min,nums[mid]);
            
            if(nums[l]<=nums[mid] ){
              //left sorted part
                
                l=mid+1;
            }
            else {
                r=mid-1;
            }
        }
   return min;
    }
}