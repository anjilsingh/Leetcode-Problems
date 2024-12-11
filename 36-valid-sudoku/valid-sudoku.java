

import java.util.HashSet;

class Solution {
    public boolean isValid(int r, int c, char[][] board) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[r + i][c + j] == '.') continue;
                else {
                    if (hs.contains(board[r + i][c + j])) return false;
                    else {
                        hs.add(board[r + i][c + j]);
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        // Check all rows
        for (int i = 0; i < 9; i++) {
            HashSet<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                else {
                    if (seen.contains(board[i][j])) return false;
                    else {
                        seen.add(board[i][j]);
                    }
                }
            }
        }

        // Check all columns
        for (int i = 0; i < 9; i++) {
            HashSet<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                else {
                    if (seen.contains(board[j][i])) return false;
                    else {
                        seen.add(board[j][i]);
                    }
                }
            }
        }

        // Check all 3x3 grids
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValid(i, j, board)) return false;
            }
        }

        return true;
    }
}
