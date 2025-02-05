class Solution {
    public int maxArea(int[] height) {
        int mArea=Integer.MIN_VALUE;
        int l=0;
        int r=height.length-1;

        while(l<=r){
            int area=Math.min(height[r],height[l])*(r-l);
            mArea=Math.max(mArea,area);

            if(height[l]<=height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return mArea;
    }
}