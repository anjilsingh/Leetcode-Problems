class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int marea=Integer.MIN_VALUE;
        while(l<r){
              int area=Math.min(height[l],height[r])*(r-l);
              if(area>marea) marea=area;
              
            if(height[l]<height[r]) l++;
            else r--;
        }
        return marea;
    }
}