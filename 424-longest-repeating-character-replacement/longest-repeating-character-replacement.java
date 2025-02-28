class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer>mp=new HashMap<>();
        int freq=0;
        int length=0;
        
        int l=0;
        for(int r=0;r<s.length();r++){
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)+1);
            freq=Math.max(freq,mp.get(s.charAt(r)));
         
            while(r-l+1-freq>k){
                mp.put(s.charAt(l),mp.get(s.charAt(l))-1);
                l++;
            }
            length=Math.max(length,r-l+1);

        }
        return length;
    }
}