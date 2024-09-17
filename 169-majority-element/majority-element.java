class Solution {
    public int majorityElement(int[] nums) {
      
    Arrays.sort(nums); //1 1 1 2 2 2 2
    int n=nums.length;
        if(n==1){
         return nums[0];
        }
    int count=0;
        int ans=-1;
    for(int i=0;i<nums.length-1;i++){
        if(nums[i]==nums[i+1]){
            count++;
            if(count+1>n/2){
                ans=nums[i];
            }
        
        }
        else{
           count=0;
        
        }
    
    }
        return ans;
    }
}