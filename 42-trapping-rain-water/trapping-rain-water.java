class Solution {
    public int trap(int[] height) {
        //using two pointer 
        //the idea is to keep two pointer left right and instead of creating the leftmax and rightmax value 
        //while side left or right will be less we will know that it is the 
        //deciding factor and calculate for that side
        int n=height.length;
        int l=0;
        int r=n-1;
        int lMax=0;
        int rMax=0;
        int ans=0;
        while(l<=r){
          if(lMax<=rMax){
             
            if(height[l]>lMax){
              lMax=height[l];
            }
            else{
              ans=ans+lMax-height[l];
            }
             l++;
          }
            
          else{
             if(height[r]>rMax){
                rMax=height[r];
             }
              else{
          ans=ans+rMax-height[r];
              }
          
          r--;
          }
        
        }
        return ans;
        
    }
}