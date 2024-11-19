class Solution {
    public boolean isValid(char[][] board, int i, int j) {
        HashSet<Character> seen = new HashSet<>();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                char ch = board[i + r][j + c];
                if (ch != '.' && seen.contains(ch)) return false; // Check for duplicates
                if (ch != '.') seen.add(ch); // Add valid numbers
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        // Check all rows
        for (int i = 0; i < 9; i++) {
            HashSet<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.' && seen.contains(ch)) return false;
                if (ch != '.') seen.add(ch);
            }
        }

        // Check all columns
        for (int j = 0; j < 9; j++) {
            HashSet<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char ch = board[i][j];
                if (ch != '.' && seen.contains(ch)) return false;
                if (ch != '.') seen.add(ch);
            }
        }

        // Check specific 3x3 subgrids (hardcoded)
        if (!isValid(board, 0, 0)) return false;
        if (!isValid(board, 0, 3)) return false;
        if (!isValid(board, 0, 6)) return false;
        if (!isValid(board, 3, 0)) return false;
        if (!isValid(board, 3, 3)) return false;
        if (!isValid(board, 3, 6)) return false;
        if (!isValid(board, 6, 0)) return false;
        if (!isValid(board, 6, 3)) return false;
        if (!isValid(board, 6, 6)) return false;

        return true; // If all checks pass
    }
}
