class Solution {
    public int lengthOfLongestSubstring(String s) {
        int mLen=0;
        int l=0;
        HashSet<Character>seen=new HashSet<>();
        for(int r=0;r<s.length();r++){
           
           while(seen.contains(s.charAt(r))){
            seen.remove(s.charAt(l));
            l++;
           }
           seen.add(s.charAt(r));
           mLen=Math.max(mLen,r-l+1);
        }
        return mLen;
    }
}