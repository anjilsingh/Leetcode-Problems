class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        
        if(s2.length()<s1.length()) return false;
        if(s1.equals(s2)) return true;
        
        char[] s1ch=s1.toCharArray();
        Arrays.sort(s1ch);
        String ss1=new String(s1ch);
        
        for(int i=0;i<s2.length();i++){
          for(int j=i;j<s2.length();j++){
           if(j-i+1==s1.length()){
               char[] wch=s2.substring(i,j+1).toCharArray();
               Arrays.sort(wch);
               String ss2=new String(wch);
               if(ss2.equals(ss1)) return true;
           }
          }
        }
        return false;
    }
}