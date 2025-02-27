class Solution {
    public int trap(int[] height) {
        int leftMax=0;
        int rightMax=0;
        int left=0;
        int right=height.length-1;
        int ans=0;
        while(left<=right){
            if(leftMax<=rightMax){
                if(leftMax>height[left]){
                  ans+=leftMax-height[left];
                }
                else{
                    leftMax=height[left];
                }
                left++;
            }

            else{
                if(rightMax>height[right]){
                    ans+=rightMax-height[right];
                }
                else{
                    rightMax=height[right];
                }
                right--;
            }
        }
        return ans;
    }
}