class Solution {
    public int maxArea(int[] height) {
        //brute force can be to check for all pair
        
        int maxArea=Integer.MIN_VALUE;
        
        int l=0;
        int r=height.length-1;
        
        while(l<r){
            int area=Math.min(height[l],height[r])*(r-l);
            maxArea=Math.max(area,maxArea);
            
            if(height[l]<=height[r]){
                
                l++;
            }
            else{
             r--;
            }
        }
        return maxArea;
    }
}