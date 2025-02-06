import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]); // Max Heap
        int x = 0;
        
        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{i, nums[i]});
            
            // Ensure we have at least `k` elements before recording max
            if (i >= k - 1) {
                // Remove elements that are out of the current window
                while (!pq.isEmpty() && pq.peek()[0] <= i - k) {
                    pq.poll();
                }
                
                // Store the maximum element of the current window
                output[x++] = pq.peek()[1];
            }
        }
        
        return output;
    }
}
