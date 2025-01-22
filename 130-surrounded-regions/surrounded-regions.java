import java.util.*;

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] vis = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        // Add all boundary 'O's to the queue and mark them as visited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && board[i][j] == 'O') {
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        // Directions for BFS traversal
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Perform BFS to mark all 'O's connected to the boundary
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];

            for (int k = 0; k < 4; k++) {
                int newR = r + dx[k];
                int newC = c + dy[k];

                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && board[newR][newC] == 'O' && !vis[newR][newC]) {
                    q.add(new int[]{newR, newC});
                    vis[newR][newC] = true;
                }
            }
        }

        // Replace all unvisited 'O's with 'X'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
