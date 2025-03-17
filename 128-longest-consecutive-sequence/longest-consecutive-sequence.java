class Solution {
    public int longestConsecutive(int[] nums) {
        int ans=0;
        HashSet<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        for(int num:set){
            if(set.contains(num-1)){
                continue;
            }
            else{
               int l=1;
               while(set.contains(num+l)){
                 l++;
               }
               ans=Math.max(l,ans);
            }
        }
        return ans;
    }
}