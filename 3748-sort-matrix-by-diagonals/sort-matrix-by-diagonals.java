import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        
        // Sort bottom-left diagonals (including middle diagonal) in non-increasing order
        for (int i = 0; i < n; i++) {
            sortDiagonal(grid, i, 0, false);
        }
        for (int j = 1; j < n; j++) {
            sortDiagonal(grid, 0, j, true);
        }
        
        return grid;
    }
    
    private void sortDiagonal(int[][] grid, int row, int col, boolean ascending) {
        int n = grid.length;
        List<Integer> diagonal = new ArrayList<>();
        int r = row, c = col;
        
        // Collect elements in the diagonal
        while (r < n && c < n) {
            diagonal.add(grid[r][c]);
            r++;
            c++;
        }
        
        // Sort the diagonal as per requirement
        if (ascending) {
            Collections.sort(diagonal);
        } else {
            diagonal.sort(Collections.reverseOrder());
        }
        
        // Put the sorted elements back
        r = row;
        c = col;
        int index = 0;
        while (r < n && c < n) {
            grid[r][c] = diagonal.get(index++);
            r++;
            c++;
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1,7,3},{9,8,2},{4,5,6}};
        int[][] sortedGrid = solution.sortMatrix(grid);
        
        for (int[] row : sortedGrid) {
            System.out.println(Arrays.toString(row));
        }
    }
}
