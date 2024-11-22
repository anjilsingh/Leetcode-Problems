class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer>mp=new HashMap<>();
        int l=0;
        int freq=0;
        int len=0;
        for(int r=0;r<s.length();r++){
           mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)+1);
           freq=Math.max(freq,mp.get(s.charAt(r)));
            
          while((r-l+1-freq)>k){
             mp.put(s.charAt(l),mp.get(s.charAt(l))-1);
             l++;
          }
            len=Math.max(len,r-l+1);
        }
        return len;
    }
}