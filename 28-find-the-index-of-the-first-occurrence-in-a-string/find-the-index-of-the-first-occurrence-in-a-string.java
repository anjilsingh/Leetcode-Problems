class Solution {
    public boolean compare(String s1,String s2){
          for(int i=0;i<s1.length();i++){
             if(s1.charAt(i)!=s2.charAt(i)){
                  return false;
             }
          }
        return true;
    }
    public int strStr(String haystack, String needle) {
         if(haystack.length()<needle.length()){
            return -1;
         }
        for(int i=0;i<haystack.length();i++){
            char x=haystack.charAt(i);
            if(x==needle.charAt(0) && i+needle.length()<=haystack.length()){
             boolean res=compare(haystack.substring(i,i+needle.length()),needle);
             if(res)
              {
                return i;
                  
              }
            }
        }
        return -1;
    }
}