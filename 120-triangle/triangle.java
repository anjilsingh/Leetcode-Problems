class Solution {
    public int solve(int i,int j,List<List<Integer>>triangle,int[][] dp){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }

        if(dp[i][j]!=-1) return dp[i][j];
        int down=solve(i+1,j,triangle,dp);
        int right=solve(i+1,j+1,triangle,dp);

        return dp[i][j]=triangle.get(i).get(j)+Math.min(down,right);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n+1][n+1];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
        return solve(0,0,triangle,dp);
    }
}