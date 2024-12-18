class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length=0;
        //lets see the bf generate all substring 
        //without repeating characters
        
        
        for(int i=0;i<s.length();i++){
            HashSet<Character>seen=new HashSet<>();
           for(int j=i;j<s.length();j++){
              if(seen.contains(s.charAt(j))) break;
              else{
                  seen.add(s.charAt(j));
                  length=Math.max(length,j-i+1);
              }
           }
        }
        return length;
    }
}