class Solution {
    public int longestConsecutive(int[] nums) {
        //briteforce approach be like sort the array and count
        if(nums.length==0||nums.length==1) return nums.length;
        int len=1;
        int maxLen=1;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1] ) continue;
            else if(nums[i]==nums[i-1]+1){
                len++;
            }
            else{

            maxLen=Math.max(len,maxLen);
            len=1;
            }
        }
        return Math.max(maxLen,len);
    }
}