class Solution {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while (l1 >= 0 || l2 >= 0 || carry > 0) {
            int t1 = 0, t2 = 0;

            if (l1 >= 0) {
                t1 = num1.charAt(l1) - '0';  // Convert char to int
                l1--;
            }
            if (l2 >= 0) {
                t2 = num2.charAt(l2) - '0';  // Convert char to int
                l2--;
            }

            int sum = t1 + t2 + carry;  // Add carry
            carry = sum / 10;  // Calculate new carry
            sb.append(sum % 10);  // Append the digit

        }

        return sb.reverse().toString();  // Reverse the result and convert to string
    }
}
