class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>seen=new HashSet<>();
        for(int num:nums){
           seen.add(num);
        }
        
        int ans=0;
        for(int num:nums){
           if(seen.contains(num-1)) continue;
           
               int l=1;
               while(seen.contains(num+l)) l++;

              ans=Math.max(ans,l);
            
        }
        return ans;
    }
}