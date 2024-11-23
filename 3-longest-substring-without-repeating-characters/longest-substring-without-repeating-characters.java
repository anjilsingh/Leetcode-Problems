class Solution {
    // public static boolean isUnique(String str){
    //  HashSet<Character>seen=new HashSet<>();
    //     for(char c:str.toCharArray()){
    //       if(seen.contains(c)) return false;
    //         seen.add(c);
    //     }
    //     return true;
    // }
    public int lengthOfLongestSubstring(String s) {
        
        //bruteforce approach 
        //first i will do the most basic approach
        int len=0;
        for(int i=0;i<s.length();i++){
            HashSet<Character>seen=new HashSet<>();
         for(int j=i;j<s.length();j++){
             if(seen.contains(s.charAt(j))){
              break;
             }
             else{
                 len=Math.max(len,j-i+1);
                 seen.add(s.charAt(j));
             }
         
         }
        }
        return len;
    }
}