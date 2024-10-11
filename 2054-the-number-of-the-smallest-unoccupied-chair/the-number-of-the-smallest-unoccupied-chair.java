import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        // Priority Queue to track available chairs
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        // Priority Queue to track friends leaving with {leaveTime, chair} pair
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Pre-fill available chairs for each friend
        for (int i = 0; i < n; i++) {
            availableChairs.offer(i);
        }
        
        // Augment times with index (friend number) for tracking
        int[][] timesWithIndex = new int[n][3];
        for (int i = 0; i < n; i++) {
            timesWithIndex[i][0] = times[i][0];  // arrival time
            timesWithIndex[i][1] = times[i][1];  // leaving time
            timesWithIndex[i][2] = i;            // friend number
        }
        
        // Sort based on arrival times
        Arrays.sort(timesWithIndex, (a, b) -> a[0] - b[0]);
        
        for (int[] time : timesWithIndex) {
            int arrival = time[0];
            int leaving = time[1];
            int friend = time[2];
            
            // Free chairs of friends that have left by this arrival time
            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= arrival) {
                availableChairs.offer(occupiedChairs.poll()[1]);
            }
            
            // The smallest available chair is assigned
            int assignedChair = availableChairs.poll();
            
            // If this is the targetFriend, return the chair number
            if (friend == targetFriend) {
                return assignedChair;
            }
            
            // Mark this chair as occupied until the friend leaves
            occupiedChairs.offer(new int[] {leaving, assignedChair});
        }
        
        return -1;  // should never reach here
    }
}
