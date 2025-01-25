class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        int i = 0;

        // Add all intervals that end before the newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        // Merge all overlapping or touching intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        mergedIntervals.add(newInterval);

        // Add all remaining intervals
        while (i < n) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        // Convert ArrayList to array
        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
    }
}
