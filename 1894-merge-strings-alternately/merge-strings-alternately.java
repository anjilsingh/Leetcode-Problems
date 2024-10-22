class Solution {
    public String mergeAlternately(String word1, String word2) {
        int p1=0;
        int p2=0;
        String resString="";
        while(p1<word1.length() && p2<word2.length()){
            resString=resString+word1.charAt(p1);
            resString=resString+word2.charAt(p2);
            p1++;
            p2++;
        }
        while(p1<word1.length()){
            resString=resString+word1.charAt(p1);
            p1++;

        }
        while(p2<word2.length()){
            resString=resString+word2.charAt(p2);
            p2++;

        }
        return resString;
    }
}