class Solution {
    public int solve(int i,int j,int m,int n,int[][] obstacleGrid,int[][] dp){
        if(i==m-1 && j==n-1){
           return obstacleGrid[i][j]==1?0:1;
        }
        if(i>=m ||j>=n ||obstacleGrid[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        return dp[i][j]=solve(i+1,j,m,n,obstacleGrid,dp)+solve(i,j+1,m,n,obstacleGrid,dp);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
         return solve(0,0,m,n,obstacleGrid,dp);
    }
}