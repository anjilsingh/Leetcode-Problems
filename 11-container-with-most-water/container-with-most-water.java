class Solution {
    public int maxArea(int[] height) {
        int mArea=0;
        int l=0;
        int r=height.length-1;
        while(l<r){
            int area=Math.min(height[l],height[r])*(r-l);
            mArea=Math.max(mArea,area);

            if(height[l]<=height[r]){
                l++;
            }
            else if(height[r]<height[l]){
                r--;
            }
        }
        return mArea;
    }
}