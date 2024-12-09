class Solution {
    public int[] productExceptSelf(int[] nums) {
        //secon method count the number of zeroes 
        
        int count=0;
        int prod=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) count++;
            else  prod=prod*nums[i];
        }
        
        int res[] =new int[nums.length];
        
        // if(count>=2) return res;
         if(count==1){
             for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                   res[i]=prod;
                    return res;
                
                }
             }
        
        }
        else if(count==0){
              for(int i=0;i<nums.length;i++){
                  res[i]=prod/nums[i];
              }
        }
        
        return res;
        
    }
}