class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer>mp=new HashMap<>();
        int maxFreq=0;
        int l=0;
        int length=Integer.MIN_VALUE;
        for(int r=0;r<s.length();r++){
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)+1);
            maxFreq=Math.max(maxFreq,mp.get(s.charAt(r)));

            if(r-l+1-maxFreq>k){
                mp.put(s.charAt(l),mp.get(s.charAt(l))-1);
                l++;
                maxFreq=Math.max(maxFreq,mp.get(s.charAt(r)));
            }
            length=Math.max(length,r-l+1);
        }

        return length;
    }
}