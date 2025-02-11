import java.util.*;

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        
        // Step 1: Compute the longest increasing streak at each index
        int[] inc = new int[n]; // inc[i] stores the longest increasing sequence starting at index i
        inc[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                inc[i] = inc[i + 1] + 1;
            } else {
                inc[i] = 1;
            }
        }

        // Step 2: Binary search for the maximum k
        int left = 1, right = n / 2, maxK = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Middle value of k
            
            if (isPossible(nums, inc, mid)) {
                maxK = mid;  // Update maxK since mid is a valid k
                left = mid + 1;  // Try for a larger k
            } else {
                right = mid - 1; // Reduce k
            }
        }
        return maxK;
    }

    // Helper function to check if two adjacent increasing subarrays of size k exist
    private boolean isPossible(List<Integer> nums, int[] inc, int k) {
        int n = nums.size();
        for (int i = 0; i <= n - 2 * k; i++) { // Ensure space for two adjacent subarrays
            if (inc[i] >= k && inc[i + k] >= k) { // Both subarrays of length k are increasing
                return true;
            }
        }
        return false;
    }

    // Main method for testing
   
}
