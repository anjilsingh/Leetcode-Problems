class Solution {
    public int characterReplacement(String s, int k) {
        //lets do it by sliding winow approach the idea is 
        //that we will add one element in a map 
        //and then we will remove it from left side while
        //lenWinodw-mfreq>k
        //after that we will update len 
        //finallly return the final length
        
        
        int len=0;
        int l=0;
        HashMap<Character,Integer>mp=new HashMap<>();
        int mfreq=0;
        
        for(int r=0;r<s.length();r++){
          mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)+1);
          mfreq=Math.max(mfreq,mp.get(s.charAt(r)));
                 
          while(r-l+1-mfreq>k){
            mp.put(s.charAt(l),mp.getOrDefault(s.charAt(l),0)-1);
            l++;
            mfreq=Math.max(mfreq,mp.get(s.charAt(r)));
          }
          len=Math.max(len,r-l+1);
        }
                 return len;
    }
}