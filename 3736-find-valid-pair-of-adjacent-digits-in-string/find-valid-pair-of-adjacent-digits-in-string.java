class Solution {
    public String findValidPair(String s) {
        HashMap<Character,Integer>mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<s.length()-1;i++){
            char first=s.charAt(i);
            char sec=s.charAt(i+1);

            int firstNum=first-'0';
            int secNum=sec-'0';

            if(first!=sec && mp.get(first)==firstNum && mp.get(sec)==secNum){
                return s.substring(i,i+2);
            }

        }
        return "";
    }
}