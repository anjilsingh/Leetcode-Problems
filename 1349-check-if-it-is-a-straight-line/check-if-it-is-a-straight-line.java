class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // Get the differences between the first two points
        int deltaX = coordinates[1][0] - coordinates[0][0];
        int deltaY = coordinates[1][1] - coordinates[0][1];

        // Check the differences for all subsequent points
        for (int i = 2; i < coordinates.length; i++) {
            int currentDeltaX = coordinates[i][0] - coordinates[0][0];
            int currentDeltaY = coordinates[i][1] - coordinates[0][1];

            // Cross-multiply to check if the differences are proportional
            if (deltaY * currentDeltaX != deltaX * currentDeltaY) {
                return false;
            }
        }

        return true;
    }
}
