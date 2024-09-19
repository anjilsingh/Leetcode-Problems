class Solution {
    public static int binSearch(int[] nums, int start, int end, int target) {
        // Base case: if the range becomes invalid, return where to insert
        if (start > end) {
            return start; // Position to insert the target
        }
        
        // Calculate the midpoint correctly
        int half = (start + end) / 2;
        
        // If the target is found, return the index
        if (nums[half] == target) {
            return half;
        }
        // If target is smaller, search in the left half
        else if (target < nums[half]) {
            return binSearch(nums, start, half - 1, target);
        }
        // If target is larger, search in the right half
        else {
            return binSearch(nums, half + 1, end, target);
        }
    }

    public int searchInsert(int[] nums, int target) {
        int end = nums.length - 1;
        // Call the recursive binary search function
        return binSearch(nums, 0, end, target);
    }
}
