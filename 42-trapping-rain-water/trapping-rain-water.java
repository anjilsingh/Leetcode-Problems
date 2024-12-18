class Solution {
    public int trap(int[] height) {
       //lets do it by two poninter approach
        
    //so which is the deciding factor 
        //we can find the value from both side lefftmax and rightmax
        //from leess side value we can easily find further 
        
        
        int leftMax=0;
        int rightMax=0;
        int left=0;
        int right=height.length-1;
        int amount=0;
        while(left<=right){
            if(leftMax<=rightMax){
                if(height[left]<leftMax){
                    amount+=leftMax-height[left];
                    
                }
                else{
                    
                    leftMax=height[left];
                }
                left++;
            }
            else{
                if(height[right]<rightMax){
                    
                    amount+=rightMax-height[right];
                }
                else{
                rightMax=height[right];
                }
                right--;
            }
        }
        return amount;
    }
}