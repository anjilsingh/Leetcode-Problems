class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int ans=0;
        for(int num:set){
          if(set.contains(num-1)){
            continue;
          }
          else{
            int l=1;
            while(set.contains(num+l)){
                l++;
            }
            ans=Math.max(ans,l);
          }
        }
        return ans;
    }
}