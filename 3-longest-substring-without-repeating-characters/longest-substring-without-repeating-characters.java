class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        for(int i=0;i<s.length();i++){
            HashSet<Character>seen=new HashSet<>();
            for(int j=i;j<s.length();j++){
              if(seen.contains(s.charAt(j))) break;
              else{
               maxLength=Math.max(maxLength,j-i+1);
               seen.add(s.charAt(j));
              }
            }
        }
        return maxLength;
    }
}