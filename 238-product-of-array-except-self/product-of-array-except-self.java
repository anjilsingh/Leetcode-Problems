class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        //first we keep multiply our answer from front side
        ans[0]=1;
        for(int i=1;i<n;i++){
             ans[i]=ans[i-1]*nums[i-1];
        }
        int post=1;
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
               ans[i]=ans[i]*post;
               post=nums[i]*post;
            }
            else{
              ans[i]=ans[i]*post;
              post=post*nums[i];
            }
        }
        return ans;
    }
}