class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        HashSet<Character>seen=new HashSet<>();
        int l=0;
        int maxLength=0;
        for(int r=0;r<s.length();r++){
            while(seen.contains(s.charAt(r))){
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            maxLength=Math.max(maxLength,r-l+1);

        }

        return maxLength;
    }
}