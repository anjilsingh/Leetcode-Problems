class Solution {
    public int characterReplacement(String s, int k) {
        //len -mFreq>k then w e cant do
        int mLen=0;
        HashMap<Character,Integer>mp=new HashMap<>();
        int l=0;
        int mfreq=0;
        for(int r=0;r<s.length();r++){
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)+1);
            mfreq=Math.max(mfreq,mp.get(s.charAt(r)));
            while(r-l+1-mfreq>k){
                mp.put(s.charAt(l),mp.get(s.charAt(l))-1);
                l++;
            }
            mLen=Math.max(mLen,r-l+1);

        }
        return mLen;
    }
}