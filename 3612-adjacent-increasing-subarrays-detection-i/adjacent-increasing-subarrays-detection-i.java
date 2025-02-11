import java.util.*;

class Solution {
    public boolean isIncreasing(List<Integer> nums, int index, int k) {
        if (index + k > nums.size()) { // Prevent out-of-bounds access
            return false;
        }
        for (int i = index; i < index + k - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) { // Strictly increasing condition
                return false;
            }
        }
        return true;
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for (int i = 0; i <= n - 2 * k; i++) { // Ensure space for two adjacent k-length subarrays
            if (isIncreasing(nums, i, k) && isIncreasing(nums, i + k, k)) {
                return true;
            }
        }
        return false;
    }

}