class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int length=Integer.MIN_VALUE;
        int l=0;
        HashSet<Character>set=new HashSet<>();
        for(int r=0;r<s.length();r++){
          while(set.contains(s.charAt(r))){
            set.remove(s.charAt(l));
            l++;
          }
          set.add(s.charAt(r));
          length=Math.max(length,r-l+1);
        }
        return length;
    }
}