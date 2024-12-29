class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans=new int[nums.length];
        int prod=1;
        int zeroCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) {
                zeroCount++;
            }
            else{
                prod*=nums[i];
            }
        }

        if(zeroCount>=2) return ans;
        else if(zeroCount==1) {
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    ans[i]=prod;
                    return ans;
                }
            }
        }
        else{
            for(int i=0;i<nums.length;i++){
                ans[i]=prod/nums[i];
                
            }
        }
      return ans;
       // return ans;
    }
}