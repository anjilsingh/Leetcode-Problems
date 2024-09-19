class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse the array from the last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If digit is 9, set it to 0
            digits[i] = 0;
        }

        // If we are here, it means all the digits were 9
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1; // Set the most significant digit to 1
        return newNumber;
    }
}