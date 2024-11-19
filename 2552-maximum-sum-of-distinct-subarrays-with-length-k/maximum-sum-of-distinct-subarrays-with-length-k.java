class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        HashSet<Integer> seen = new HashSet<>();
        
        int start = 0; // Start of the sliding window
        
        for (int end = 0; end < nums.length; end++) {
            // Expand the window by adding the current element
            while (seen.contains(nums[end])) {
                // Remove elements from the start until `nums[end]` is unique
                currentSum -= nums[start];
                seen.remove(nums[start]);
                start++;
            }
            seen.add(nums[end]);
            currentSum += nums[end];
            
            // Check if the window size is `k`
            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                // Shrink the window from the start
                currentSum -= nums[start];
                seen.remove(nums[start]);
                start++;
            }
        }
        
        return maxSum;
    }
}
