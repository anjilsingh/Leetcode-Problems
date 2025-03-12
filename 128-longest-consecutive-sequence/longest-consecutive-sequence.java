class Solution {

    public int longestConsecutive(int[] nums) {
        
        int ans=0;
        HashSet<Integer>seen=new HashSet<>();
        for(int num:nums){
            seen.add(num);
        }
        for(int num:seen){
            if(seen.contains(num-1)) continue;

            else{
                int l=1;
                while(seen.contains(num+l)){
                    l++;
                }
                ans=Math.max(l,ans);
            }
        }
        return ans;
    }
}