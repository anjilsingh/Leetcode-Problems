class Solution {
    public int trap(int[] height) {
        int leftMax=0;
        int rightMax=0;
        int left=0;
        int right=height.length-1;
        int answer=0;
        
        while(left<=right){
            if(leftMax<=rightMax){
                //so i can compute for the left part
             if(height[left]<leftMax){
               answer+=leftMax-height[left];
             }
                else{
                    leftMax=height[left];
                }
                left++;
            }
            else{
                 if(height[right]<rightMax){

                  answer+=rightMax-height[right];
                 }
                else{
                    rightMax=height[right];

                 }
                right--;

            }

        }
        return answer;
    }
}