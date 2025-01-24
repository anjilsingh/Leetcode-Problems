class Solution {
    public boolean canJump(int[] nums) {
        //till step i will try to go for the max 
     int n=nums.length;
     int dest=n-1;
     for(int i=n-2;i>=0;i--){
        if(nums[i]+i>=dest){
            dest=i;
        }
     }
     return dest==0;
        
    }
}