class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = Integer.MIN_VALUE;
        int maxPrefix = values[0]; // Keeps track of max (values[i] + i) seen so far

        for (int j = 1; j < values.length; j++) {
            // Compute the score for pair (i, j) where i < j
            maxScore = Math.max(maxScore, maxPrefix + values[j] - j);

            // Update maxPrefix for the next iteration
            maxPrefix = Math.max(maxPrefix, values[j] + j);
        }

        return maxScore;
    }
}
