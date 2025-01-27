class Solution {
    public int solve(String s,int i,int n,int[] dp){
        if(i>=s.length()){
            return 1; //found one valid 
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        if(s.charAt(i)=='0') return dp[i]=0;

        int res=solve(s,i+1,n,dp);
        if(i<s.length()-1){
            if(s.charAt(i)=='1'||s.charAt(i)=='2'&& s.charAt(i+1)<='6'){
                res+=solve(s,i+2,n,dp);
            }
        }
        return dp[i]=res;
    }
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(s,0,n,dp);

    }
}