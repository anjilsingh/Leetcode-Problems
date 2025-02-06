import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int operations = 0;
        int index = 0; // Tracks the number of removed elements
        
        while (index < nums.length) {
            seen.clear(); // Reset set for the remaining elements
            
            // Add remaining elements to the set
            for (int i = index; i < nums.length; i++) {
                seen.add(nums[i]);
            }
            
            // If all remaining elements are unique, return operations count
            if (seen.size() == nums.length - index) {
                return operations;
            }
            
            // Remove exactly 3 elements per operation
            index += 3;
            operations++;
        }
        
        return operations;
    }
}
