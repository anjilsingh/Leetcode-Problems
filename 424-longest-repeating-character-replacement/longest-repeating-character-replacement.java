class Solution {
    public int characterReplacement(String s, int k) {
        
        HashMap<Character,Integer>mp=new HashMap<>();
        int len=0;
        int mFreq=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)+1);
            mFreq=Math.max(mFreq,mp.get(s.charAt(r)));

            while(r-l+1-mFreq>k){
                mp.put(s.charAt(l),mp.get(s.charAt(l))-1);
                l++;
                mFreq=Math.max(mFreq,mp.get(s.charAt(r)));
            }
            len=Math.max(len,r-l+1);

        }
        return len;
    }
}