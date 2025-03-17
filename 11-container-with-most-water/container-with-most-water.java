class Solution {
    public int maxArea(int[] height) {
        int marea=0;
        int l=0;
        int r=height.length-1;
        while(l<r){
            int area=Math.min(height[l],height[r])*(r-l);
            marea=Math.max(area,marea);

            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return marea;
    }
}