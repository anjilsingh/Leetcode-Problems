
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        // Step 1: Change all negative numbers to the nearest positive equivalent
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] += ((Math.abs(nums[i]) / value) * value);
                if (nums[i] < 0) {
                    nums[i] += value;
                }
            }
        }

        // Step 2: Create an array to store the frequency of remainders
        int[] a = new int[100001]; // Array to store remainder frequencies, initialized to 0

        // Step 3: Store frequencies of all remainders when divided by 'value'
        for (int num : nums) {
            a[num % value]++;
        }

        // Step 4: Find the smallest missing remainder based on frequencies
        int n = nums.length / value + 1;  // Calculating an upper bound for iterations
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < value; i++) {
                if (a[i] == j) {
                    return value * j + i;  // Return the smallest missing integer
                }
            }
        }

        return 0;  // In case no value is found (which is unlikely given the logic)
    }
}
