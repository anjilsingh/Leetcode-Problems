public class Solution {
    public int reverse(int x) {
        int rev = 0;
        
        while (x != 0) {
            int digit = x % 10;  // Extract last digit
            
            // Check for overflow before adding digit to rev
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
            
            rev = rev * 10 + digit;  // Append digit to rev
            x /= 10;  // Remove last digit from x
        }
        
        return rev;
    }
}
