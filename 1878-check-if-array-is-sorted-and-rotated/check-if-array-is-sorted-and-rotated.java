class Solution {
    public boolean check(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                cnt++;
            }
        }
        // If the last element is greater than the first, it's another breakpoint.
        if (nums[n - 1] > nums[0]) {
            cnt++;
        }
        
        return cnt <= 1;
    }
}
