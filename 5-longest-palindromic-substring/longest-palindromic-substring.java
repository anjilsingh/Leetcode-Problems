class Solution {
    Boolean[][] dp;
    public boolean isPali(String s, int i, int j){
         if(i>=j){
            return true;
         }
         if(dp[i][j]!=null){
            return dp[i][j];
         }
         if(s.charAt(i)!=s.charAt(j)) return dp[i][j]=false;

         return dp[i][j]=isPali(s,i+1,j-1);
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        dp=new Boolean[1001][1001];
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