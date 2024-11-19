class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0 ||nums.length==1) return nums.length;
        HashSet<Integer>set=new HashSet<>();
        
        for(int num:nums) set.add(num);
        int maxLen=1;
        for(int num:nums){
            //if left point is present then skip as this can tbe starting pont
            if(set.contains(num-1)) continue;
            //else this will be a starting point
            int len=1;
            while(set.contains(num+len)){
               len++;
            }
            maxLen=Math.max(len,maxLen);
            
        }
        return maxLen;
    }
}