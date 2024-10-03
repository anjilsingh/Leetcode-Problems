class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length]; // New array to hold the rearranged numbers
        int pos = 0;  // Position for placing positive numbers (even indices)
        int neg = 1;  // Position for placing negative numbers (odd indices)

        // Loop through the original array
        for (int i = 0; i < nums.length; i++) {
            // Place positive numbers at even indices
            if (nums[i] > 0 && pos < nums.length) {
                result[pos] = nums[i];
                pos += 2; // Move to the next even index
            } 
            // Place negative numbers at odd indices
            else if (nums[i] < 0 && neg < nums.length) {
                result[neg] = nums[i];
                neg += 2; // Move to the next odd index
            }
        }

        return result; // Return the rearranged array
    }
}
