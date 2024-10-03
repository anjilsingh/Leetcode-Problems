class Solution {
    public void rotate(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int res[][]=new int[row][col];
        for(int i=0;i<row;i++){
           for(int j=0;j<col;j++){
                  res[i][j]=matrix[row-j-1][i];
           }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j]=res[i][j];
            }
        }
       
    }
}