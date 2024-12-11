class Solution {
    public int trap(int[] height) {
        //let do it by using two pointer approach
        
        //leftMax and rightMax find it from both side 
        //since min is deciding factor so which side the value is min
        //that will be dceiding factor and we can calculate that side and then mive further 
        int l=0;
        int r=height.length-1;
        int leftMax=0;
        int rightMax=0;
        int ans=0;
        while(l<=r){
          if(leftMax<=rightMax){

              if(leftMax-height[l]>0){
                 ans+=leftMax-height[l];
              }
              else{
                 leftMax=height[l];
              }
             l++;
          }
          else{
              
              if(rightMax-height[r]>0){
               ans+=rightMax-height[r];
              }
              else{
                 rightMax=height[r];
              }
              r--;
          }
        }
        return ans;
    }
}