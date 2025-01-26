import java.util.*;

public class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Result array
        int[] result = new int[queries.length];
        
        // Map to store the result for each query
        Map<Integer, Integer> queryResultMap = new HashMap<>();
        
        // Sort intervals by their start points
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Create a copy of queries and sort it
        int[] sortedQueries = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortedQueries);
        
        // Min-heap to store intervals based on their length
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));
        
        int i = 0; // Pointer for intervals
        for (int q : sortedQueries) {
            // Add intervals to the heap that can contain the current query
            while (i < intervals.length && intervals[i][0] <= q) {
                minHeap.offer(intervals[i]);
                i++;
            }
            
            // Remove intervals from the heap that cannot contain the current query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            
            // Get the smallest interval from the heap
            if (!minHeap.isEmpty()) {
                int[] smallestInterval = minHeap.peek();
                queryResultMap.put(q, smallestInterval[1] - smallestInterval[0] + 1);
            } else {
                queryResultMap.put(q, -1);
            }
        }
        
        // Populate the result array using the original order of queries
        for (int j = 0; j < queries.length; j++) {
            result[j] = queryResultMap.get(queries[j]);
        }
        
        return result;
    }
}
