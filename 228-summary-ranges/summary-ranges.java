class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        
        if (nums.length == 0) {
            return ans;
        }
        
        int l = 0;  // Start of the current range
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                // Current number breaks the consecutive sequence
                if (l == i - 1) {
                    ans.add(String.valueOf(nums[l]));  // Single element range
                } else {
                    ans.add(nums[l] + "->" + nums[i - 1]);  // Range of more than 1 element
                }
                l = i;  // Update the start of the next range
            }
        }
        
        // Add the last range after the loop
        if (l == nums.length - 1) {
            ans.add(String.valueOf(nums[l]));
        } else {
            ans.add(nums[l] + "->" + nums[nums.length - 1]);
        }
        
        return ans;
    }
}
