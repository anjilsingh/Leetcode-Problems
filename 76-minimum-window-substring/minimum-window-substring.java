class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.length() == 0) return "";
        if (s.equals(t)) return s;

        int[] ind = {-1, -1};

        // Map to store character counts for `t`
        HashMap<Character, Integer> requiredCounts = new HashMap<>();
        for (char c : t.toCharArray()) {
            requiredCounts.put(c, requiredCounts.getOrDefault(c, 0) + 1);
        }

        int need = requiredCounts.size(); // Unique characters in `t`
        int have = 0;
        HashMap<Character, Integer> windowCounts = new HashMap<>();
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            // Add character to the window
            char curr = s.charAt(r);
            windowCounts.put(curr, windowCounts.getOrDefault(curr, 0) + 1);

            // Check if the current character satisfies a requirement
            if (requiredCounts.containsKey(curr) && windowCounts.get(curr).intValue() == requiredCounts.get(curr).intValue()) {
                have++;
            }

            // Shrink the window while it contains all required characters
            while (have == need) {
                // Update result if the current window is smaller
                if (ind[0] == -1 || r - l + 1 < ind[1] - ind[0] + 1) {
                    ind[0] = l;
                    ind[1] = r;
                }

                // Remove the leftmost character from the window
                char leftChar = s.charAt(l);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (requiredCounts.containsKey(leftChar) && windowCounts.get(leftChar) < requiredCounts.get(leftChar)) {
                    have--;
                }

                l++; // Move the left pointer
            }
        }

        if (ind[0] == -1) return ""; // No valid window found
        return s.substring(ind[0], ind[1] + 1); // Return the smallest window
    }
}
