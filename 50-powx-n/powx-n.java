class Solution {
    public double myPow(double x, int n) {
        // Handle base case where n is 0
        if (n == 0) {
            return 1.0; // Any number to the power of 0 is 1
        }
        
        // Handle negative exponent case
        if (n < 0) {
            x = 1 / x; // Convert x to its reciprocal
            // Special case for Integer.MIN_VALUE to avoid overflow
            if (n == Integer.MIN_VALUE) {
                return x * myPow(x, Integer.MAX_VALUE); // Handle separately
            }
            n = -n; // Convert n to positive
        }

        // Use exponentiation by squaring
        double half = myPow(x, n / 2); // Recursively calculate x^(n/2)
        if (n % 2 == 0) {
            return half * half; // If n is even
        } else {
            return half * half * x; // If n is odd
        }
    }
}
