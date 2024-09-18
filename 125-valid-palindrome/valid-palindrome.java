import java.util.*;

class Solution {
    // Reverse a string using char array
    public String reverse(String str) {
        char[] r = str.toCharArray();
        int l = 0;
        int m = str.length() - 1;
        
        // Perform in-place swapping of characters
        while (l <= m) {
            char temp = r[l];
            r[l] = r[m];
            r[m] = temp;
            l++;
            m--;
        }
        
        // Convert the char array back to a String
        return new String(r);
    }

    // Check if a string is a palindrome
    public boolean isPalindrome(String s) {
        // Remove all non-alphanumeric characters and convert to lowercase
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Reverse the cleaned string
        String rev = reverse(str);

        // Check if the original cleaned string is equal to the reversed string
        return str.equals(rev);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "A man, a plan, a canal: Panama";
        
        // Check if the string is a palindrome
        boolean result = solution.isPalindrome(input);
        
        System.out.println(result); // Output: true
    }
}
