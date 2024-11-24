class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //lets see the brute force approach
        //the idea is to find all substring of size s1 in s2 and then sort both and 
        //cmpare if true return immediatey treu 
        //otherwise compare all substring and finally if not matched return 
        //false
        
        //hahaha done:)
        
        if(s2.length()<s1.length()) return false;
        if(s2.equals(s1)) return true;
        
        char[] s1char=s1.toCharArray();
        Arrays.sort(s1char);
        String sortedS1=new String(s1char);
        
        
        for(int i=0;i<s2.length();i++){
          for(int j=i;j<s2.length();j++){
            if(j-i+1==s1.length()){

             char[] s2char=s2.substring(i,j+1).toCharArray();
             Arrays.sort(s2char);
             String sorteds2=new String(s2char);
            if(sortedS1.equals(sorteds2)) return true;
            }
          }
        
        }
        return false;
    }
}