class Solution {
    public int maxDifference(String s) {
          
        HashMap<Character,Integer>mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
      

        int minEven=Integer.MAX_VALUE;
        int maxOdd=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(mp.get(ch)%2==0){
                minEven=Math.min(minEven,mp.get(ch));
            }
            else{
                maxOdd=Math.max(maxOdd,mp.get(ch));
            }
        }

        return maxOdd-minEven;
    }
}