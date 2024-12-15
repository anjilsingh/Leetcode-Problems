class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //lets see the bruteforce approach
        
        int len=s.length();
        int mlen=0;
        for(int i=0;i<len;i++){
            HashSet<Character>seen=new HashSet<>();
            for(int j=i;j<len;j++){
              if(seen.contains(s.charAt(j))) break;
              else{
                seen.add(s.charAt(j));
                mlen=Math.max(mlen,j-i+1);
              }
            }
        }
        return mlen;
    }
}