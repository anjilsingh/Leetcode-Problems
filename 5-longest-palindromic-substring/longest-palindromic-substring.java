class Solution {
    public boolean isPali(String s, int i, int j){
         if(i>=j){
            return true;
         }
         if(s.charAt(i)!=s.charAt(j)) return false;

         return isPali(s,i+1,j-1);
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        int max=Integer.MIN_VALUE;
        int  start=-1;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPali(s,i,j)){
                    if(j-i+1>max){
                        max=j-i+1;
                        start=i;
                    }
                }
            }
        }

        return s.substring(start,start+max);
    }
}