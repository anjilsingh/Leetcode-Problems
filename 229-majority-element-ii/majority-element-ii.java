import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        
        if (n == 1) {
            ans.add(nums[0]);
            return ans;
        }
        
        Arrays.sort(nums);  // Sort the array to group identical elements together
        
        int count = 1;
        
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;  // Count the occurrence of the current number
            } else {
                if (count > n / 3) {
                    ans.add(nums[i - 1]);  // Add to result if count > n/3
                }
                count = 1;  // Reset the count for the new number
            }
        }
        
        // Handle the last element in the sorted array
        if (count > n / 3) {
            ans.add(nums[n - 1]);
        }
        
        // Optional: Remove duplicates if needed (in case duplicates are not allowed)
        return ans;
    }
}
