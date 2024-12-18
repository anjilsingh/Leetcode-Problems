class Solution {
    public int trap(int[] height) {
        
        //for every bar find its leftmost value and rightmax value 
        //and then take the min of those two 
        //if bar value is less then that min 
        //then find the area based on that
        
        
        int[] leftMax=new int[height.length];
        int[] rightMax=new int[height.length];
        
        
        leftMax[0]=0;
        for(int i=1;i<height.length;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i-1]);
        }
        
        rightMax[height.length-1]=0;
        for(int i=height.length-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i+1]);
        }
        
        
        int amount=0;
        for(int i=0;i<height.length;i++){
             if(Math.min(leftMax[i],rightMax[i])-height[i]>0){
              amount+=Math.min(leftMax[i],rightMax[i])-height[i];
             }
        }
        return amount;
    }
}