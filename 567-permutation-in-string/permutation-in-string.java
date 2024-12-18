class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //permutaion means same character
        //so either to sort the string 
        //or use a hashtable
        //lets see the bruteforce approach
        //generate all 
        
        if(s2.length()<s1.length()) return false;
        char[] s1char=s1.toCharArray();
        Arrays.sort(s1char);
        String sortedS1=new String(s1char);
            
        for(int i=0;i<s2.length();i++){
          for(int j=i;j<s2.length();j++){
            if(j-i+1==s1.length()){
                char[] win=s2.substring(i,j+1).toCharArray();
                Arrays.sort(win);
                String winSorted=new String(win);
                if(sortedS1.equals(winSorted)) return true;
            }
          }
        }
        
        return false;
    }
}