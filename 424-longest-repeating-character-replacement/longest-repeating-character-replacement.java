class Solution {
    public int characterReplacement(String s, int k) {
        int res=0;
        int l=0;
        int maxF=0;
        HashMap<Character,Integer>mp=new HashMap<>();
        for(int r=0;r<s.length();r++){
           mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)+1);
           maxF=Math.max(maxF,mp.get(s.charAt(r)));
            
        while((r-l+1-maxF)>k){
              mp.put(s.charAt(l),mp.get(s.charAt(l))-1);
             l++;
        }
            res=Math.max(res,r-l+1);
        }
        return res;
    }
}