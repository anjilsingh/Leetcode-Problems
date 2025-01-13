class Node {
    Node[] child; // Array to store references to child nodes (26 for each alphabet letter)
    boolean eow;  // Boolean to mark the end of a word

    Node() {
        child = new Node[26]; // Initialize the child array with 26 null nodes
        eow = false;          // Default value for end of word
    }
}

class Solution {
    private List<String> res = new ArrayList<>(); // To store the result words
    private Node root = new Node();              // Root of the Trie

    // Function to insert a word into the Trie
    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a'; // Convert character to index (0-25)
            if (curr.child[index] == null) { // If no node exists for this character
                curr.child[index] = new Node();
            }
            curr = curr.child[index]; // Move to the child node
        }
        curr.eow = true; // Mark the end of the word
    }

    // Depth First Search to find words in the board
    public void dfs(int r, int c, char[][] board, Node curr, StringBuilder path, int row, int col) {
        // Check for out of bounds or already visited cell
        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] == '#') {
            return;
        }

        char ch = board[r][c];
        int index = ch - 'a';

        if (curr.child[index] == null) { // If current character is not in Trie
            return;
        }

        curr = curr.child[index];
        path.append(ch); // Add character to the current path

        if (curr.eow) { // If a word is found
            res.add(path.toString());
            curr.eow = false; // Avoid duplicate additions
        }

        // Mark the current cell as visited
        board[r][c] = '#';

        // Explore all 4 possible directions
        dfs(r + 1, c, board, curr, path, row, col); // Down
        dfs(r - 1, c, board, curr, path, row, col); // Up
        dfs(r, c + 1, board, curr, path, row, col); // Right
        dfs(r, c - 1, board, curr, path, row, col); // Left

        // Backtrack
        board[r][c] = ch;
        path.deleteCharAt(path.length() - 1);
    }

    // Main function to find words
    public List<String> findWords(char[][] board, String[] words) {
        // Insert all words into the Trie
        for (String word : words) {
            insert(word);
        }

        int row = board.length;
        int col = board[0].length;

        // Traverse the board
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int index = board[i][j] - 'a';
                if (root.child[index] != null) { // If the first character exists in Trie
                    dfs(i, j, board, root, new StringBuilder(), row, col);
                }
            }
        }
        return res;
    }
}
