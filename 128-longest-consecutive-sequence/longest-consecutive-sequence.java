class Solution {
    public int longestConsecutive(int[] nums) {
        //longest consecutive subsequence 
        //one way is to sort the array and find the max length
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int maxLength=1;
        int ans=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                continue;
            }
            if(nums[i]==nums[i+1]-1){
                ans++;
            }
            else{
                maxLength=Math.max(maxLength,ans);
                ans=1;
            }
        }
        return Math.max(maxLength,ans);
    }
}