class Solution {
    public int minimumOperations(int[][] grid) {
        
        int row=grid.length;
        int col=grid[0].length;

        int count=0;

      
            for(int j=0;j<col;j++){
                for(int i=1;i<row;i++){
             if(grid[i][j]<=grid[i-1][j]){
                 int increase = (grid[i-1][j] - grid[i][j]) + 1;  // Increase just enough
                    grid[i][j] += increase;  // Update grid value
                    count += increase;  // Add operations to count
             }

            }
        }
        return count;
    }
}