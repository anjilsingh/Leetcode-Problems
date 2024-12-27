class Solution {
    public int maxScoreSightseeingPair(int[] values) {
          int maxScore = 0;

        // Initialize the left pointer to the first index
        int l = 0;

        // Iterate through the array starting from the second element
        for (int r = 1; r < values.length; r++) {
            // Calculate the distance between the two sightseeing spots
            int spotsDiff = r - l;

            // Calculate the score for the current pair (l, r)
            int score = values[l] + values[r] - spotsDiff;

            // Update the maximum score if this score is greater
            maxScore = Math.max(maxScore, score);

            // Check if the current spot is better to use as the left pointer
            if ((values[l] - spotsDiff) < values[r]) {
                l = r;
            }
        }

        return maxScore;
    }
}
