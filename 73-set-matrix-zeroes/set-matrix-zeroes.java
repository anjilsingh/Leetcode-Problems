class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] ini = new int[row][col]; // Make a copy of the original matrix
        
        // Copy the original matrix into the `ini` array
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ini[i][j] = matrix[i][j];
            }
        }

        // Iterate through the matrix to find zeros in `ini` and mark rows/columns in `matrix`
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ini[i][j] == 0) {
                    // Set the entire row to zero
                    for (int k = 0; k < row; k++) {
                        matrix[k][j] = 0;   // Set column values to zero
                    }
                    // Set the entire column to zero
                    for (int k = 0; k < col; k++) {
                        matrix[i][k] = 0;   // Set row values to zero
                    }
                }
            }
        }
    }
}
