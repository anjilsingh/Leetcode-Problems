import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count_fresh = 0;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                if(grid[i][j] != 0) {
                    count_fresh++;
                }
            }
        }
        
        if(count_fresh == 0) return 0;
        
        int count_min = 0;
        int cnt = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        while(!q.isEmpty()) {
            int size = q.size();
            cnt += size;
            
            for(int i = 0; i < size; i++) {
                int[] point = q.poll();
                for(int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];
                    
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    
                    grid[x][y] = 2;
                    q.offer(new int[]{x, y});
                }
            }
            
            if(!q.isEmpty()) {
                count_min++;
            }
        }
        
        return count_fresh == cnt ? count_min : -1;
    }
}
