class Solution {
    public int[] productExceptSelf(int[] nums) {
        //lets see the third approach of prefix and suffix multiplication
        int[] ans=new int[nums.length];
        int len=nums.length;
        int prefix[]=new int[len];
        int suffix[]=new int[len];
        //lets initialize prefix array
        prefix[0]=nums[0];
        for(int i=1;i<len;i++){
            prefix[i]=prefix[i-1]*nums[i];
        }
        
        //lets initialize suffix array
        suffix[len-1]=nums[len-1];
        for(int i=len-2;i>=0;i--){
            suffix[i]=suffix[i+1]*nums[i];
        }
        
        for(int i=0;i<len;i++){
            if(i==0){
              ans[i]=suffix[i+1];
            }
            else if(i==len-1){
                  ans[i]=prefix[len-2];
            }
            else{
            ans[i]=prefix[i-1]*suffix[i+1];
            }
        }
        return ans;
    }
}