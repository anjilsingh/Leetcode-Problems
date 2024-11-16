class Solution {
    public boolean isAnagram(String s, String t) {
     if(s.length()!=t.length()) return false;
     char[] sarr=s.toCharArray();
     Arrays.sort(sarr);
     char[] tarr=t.toCharArray();
     Arrays.sort(tarr);
     for(int i=0;i<sarr.length;i++){
         if(sarr[i]!=tarr[i]){
           return false;
         }
     }
        return true;
    }
}