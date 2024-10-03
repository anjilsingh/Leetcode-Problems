class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        
        // Handle edge case when matrix is empty
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = col - 1;
        int top = 0, bottom = row - 1;

        while (left <= right && top <= bottom) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++; // Move the top boundary down

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--; // Move the right boundary left

            if (top <= bottom) {
                // Traverse from right to left along the bottom row
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary up
            }

            if (left <= right) {
                // Traverse from bottom to top along the left column
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++; // Move the left boundary right
            }
        }

        return ans;
    }
}
