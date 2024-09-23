class Solution {
    public int islandPerimeter(int[][] grid) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int peri = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {  // If it's a land cell
                    for (int k = 0; k < 4; k++) {
                        int row = i + dx[k];
                        int col = j + dy[k];
                        
                        // Check if the neighboring cell is water or out of bounds
                        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
                            peri++;
                        }
                    }
                }
            }
        }
        
        return peri;
    }
}
