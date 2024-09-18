class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26]; 
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }

        // Decrease the frequency for characters in ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {
            arr[ransomNote.charAt(i) - 'a']--;
            // If frequency goes below 0, return false (not enough characters)
            if (arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true; // If all characters in ransomNote can be constructed
    }
}
