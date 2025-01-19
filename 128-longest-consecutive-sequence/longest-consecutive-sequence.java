class Solution {
    public int longestConsecutive(int[] nums) {
        int len=0;

        HashSet<Integer>seen=new HashSet<>();
        for(int num:nums){
            seen.add(num);
        }

        for(int num:seen){
            //means this is not a starting point  so just continue
            if(seen.contains(num-1))  continue;

            int l=1;
            while(seen.contains(num+l)){
                l++;
            }
            len=Math.max(len,l);
        }

        return len;
    }
}