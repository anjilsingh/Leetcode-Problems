class Solution {
    public int lengthOfLongestSubstring(String s) {
        int mlen=0;
        HashSet<Character>seen=new HashSet<>();
        int l=0;
        int r=0;
        while(r<s.length()){
            while(seen.contains(s.charAt(r))){
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            mlen=Math.max(mlen,r-l+1);
            r++;
        }
        return mlen;
    }
}