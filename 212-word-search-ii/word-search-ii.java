import java.util.*;

class Node {
    Node[] child;
    boolean eow;
    Node() {
        child = new Node[26];
        eow = false;
    }
}

class Solution {
    private Node root;  // Trie root node
    private Set<String> result;  // To store unique words found in the board
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        result = new HashSet<>();
        
        // Step 1: Insert all words into the Trie
        for (String word : words) {
            insert(word);
        }
        
        // Step 2: Traverse the board and search for words using backtracking
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                backtrack(board, i, j, root, "", visited);
            }
        }
        
        return new ArrayList<>(result);  // Convert the set to a list and return
    }
    
    // Helper function to insert a word into the Trie
    private void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.child[index] == null) {
                curr.child[index] = new Node();
            }
            curr = curr.child[index];
        }
        curr.eow = true;  // Mark the end of the word
    }
    
    // Backtracking function to search for words
    private void backtrack(char[][] board, int row, int col, Node node, String path, boolean[][] visited) {
        // Boundary checks and avoid revisiting
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]) {
            return;
        }
        
        char ch = board[row][col];
        int index = ch - 'a';
        
        // If the character is not in the Trie, return early
        if (node.child[index] == null) {
            return;
        }
        
        // Append the character to the path
        path += ch;
        node = node.child[index];
        
        // If we reach the end of a word, add it to the result set
        if (node.eow) {
            result.add(path);
        }
        
        // Mark the cell as visited
        visited[row][col] = true;
        
        // Explore all 4 directions: up, down, left, right
        backtrack(board, row - 1, col, node, path, visited);
        backtrack(board, row + 1, col, node, path, visited);
        backtrack(board, row, col - 1, node, path, visited);
        backtrack(board, row, col + 1, node, path, visited);
        
        // Backtrack: unmark the cell
        visited[row][col] = false;
    }
}
