import java.util.ArrayList;

class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        
        // Iterate over all words
        for (String word : words) {
            // Check if the word belongs to one row
            if (canBeTypedInOneRow(word)) {
                ans.add(word);
            }
        }
        
        // Convert ArrayList to String array
        String[] result = new String[ans.size()];
        result = ans.toArray(result);
        return result;
    }

    // Helper method to check if a word can be typed using one row of the keyboard
    public boolean canBeTypedInOneRow(String word) {
        String row1 = "QWERTYUIOPqwertyuiop";
        String row2 = "ASDFGHJKLasdfghjkl";
        String row3 = "ZXCVBNMzxcvbnm";
        
        int row = 0;
        
        // Identify which row the first letter of the word belongs to
        if (row1.indexOf(word.charAt(0)) != -1) {
            row = 1;
        } else if (row2.indexOf(word.charAt(0)) != -1) {
            row = 2;
        } else if (row3.indexOf(word.charAt(0)) != -1) {
            row = 3;
        }

        // Check the rest of the word's characters to ensure they belong to the same row
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if ((row == 1 && row1.indexOf(c) == -1) ||
                (row == 2 && row2.indexOf(c) == -1) ||
                (row == 3 && row3.indexOf(c) == -1)) {
                return false;
            }
        }
        return true;
    }
}
