class Solution {
    public int maximumSwap(int num) {
         char[] digits = Integer.toString(num).toCharArray();
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        
        // Store the last occurrence of each digit
        for (int i = 0; i < digits.length; i++) {
            lastOccurrence.put(digits[i], i);
        }
        
        // Traverse the digits of the number
        for (int i = 0; i < digits.length; i++) {
            // Try to find a larger digit to swap with
            for (char d = '9'; d > digits[i]; d--) {
                if (lastOccurrence.containsKey(d) && lastOccurrence.get(d) > i) {
                    // Swap the digits
                    char temp = digits[i];
                    digits[i] = d;
                    digits[lastOccurrence.get(d)] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        
        // Return the number itself if no swap is possible
        return num;
    }
}