class Solution {
    public int maxArea(int[] height) {
       //now lets see how two pointer works here 
        
        
        //so we will calculate area for a particular pos and then move pointer furtheerr 
        //from less side to more side
        int maxArea=0;
        int l=0;
        int r=height.length-1;
        while(l<r){
           int area=Math.min(height[l],height[r])*(r-l);
           maxArea=Math.max(area,maxArea);
            if(height[l]<height[r]){
              l++;
            }
            else{
                r--;
            }
        }
        return maxArea;
    }
}