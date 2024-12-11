class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] leftSide=new int[n];
        int[] rightSide=new int[n];
        leftSide[0]=0;
        rightSide[n-1]=0;
        
        for(int i=1;i<n;i++){
            leftSide[i]=Math.max(leftSide[i-1],height[i-1]);
        }
        
        for(int i=n-2;i>=0;i--){
          rightSide[i]=Math.max(rightSide[i+1],height[i+1]);
        }
        
        int ans=0;
        
        for(int i=0;i<height.length;i++){
            if((Math.min(leftSide[i],rightSide[i])-height[i])<0) continue;
            else{
                 ans+=Math.min(leftSide[i],rightSide[i])-height[i];
            }
        }
      return ans;  
    }
}