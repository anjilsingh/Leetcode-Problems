class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
    int temp[]=new int[nums.length];
        int j=0;
    for(int i=0;i<nums.length;i++){
        if(nums[i]!=0){
        temp[j++]=nums[i];
        }
    }
        for(int k=j;k<n;k++){
           temp[j++]=0;
        }
        for(int i=0;i<n;i++){
             nums[i]=temp[i];
        }
        
    }
}