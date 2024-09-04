class Pair {
    int first;
    int second; 
    public Pair(int first, int second) {
        this.first = first; 
        this.second = second; 
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        // Only add boundary cells that contain land (grid[i][j] == 1)
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                    vis[i][j] = 1;
                } 
            }
        }
        
        int[] delRow = {0, 0, -1, 1};
        int[] delCol = {-1, 1, 0, 0};
        
        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();
            
            for (int i = 0; i < 4; i++) {
                int row = r + delRow[i];
                int col = c + delCol[i];  
                
                if (row >= 0 && row < n && col >= 0 && col < m && vis[row][col] == 0 && grid[row][col] == 1) {
                    q.add(new Pair(row, col));
                    vis[row][col] = 1;
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
