class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output=new int[nums.length];
        output[0]=1;
        for(int i=1;i<output.length;i++){
            output[i]=nums[i-1]*output[i-1];
        }
        int suffix=1;
        for(int i=output.length-1;i>=0;i--){
            output[i]=suffix*output[i];
            suffix=suffix*nums[i];
        }
        return output;
        
    }
}