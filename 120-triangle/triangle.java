class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size()-1;
        int[][] dp=new int[n][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return memoziation(0,0,triangle,dp);

    }

    public int memoziation(int i,int j,List<List<Integer>>triangle,int[][]dp) {
          if(i==triangle.size()-1){
            return triangle.get(i).get(j);

          }
          if(dp[i][j]!=-1){
            return dp[i][j];
          }
          int down=memoziation(i+1,j,triangle,dp);
          int diag=memoziation(i+1,j+1,triangle,dp);

          return dp[i][j]=triangle.get(i).get(j)+Math.min(down,diag);
    }
}