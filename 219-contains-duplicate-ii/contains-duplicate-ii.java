import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a map to store elements as keys and their indices as values
        Map<Integer, Integer> mp = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the element is already in the map
            if (mp.containsKey(nums[i])) {
                // Check if the difference in indices is less than or equal to k
                if (i - mp.get(nums[i]) <= k) {
                    return true; // Found a nearby duplicate
                }
            }
            // Update the map with the current index of the element
            mp.put(nums[i], i);
        }
        return false; // No nearby duplicate found
    }
}
