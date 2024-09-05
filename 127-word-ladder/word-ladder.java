class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1)); 
        
        Set<String> st = new HashSet<>(wordList); // Directly add wordList into set
        
        st.remove(beginWord);
        
        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.poll();
            
            if (word.equals(endWord)) {
                return steps;
            }
            
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] wordChar = word.toCharArray();
                    wordChar[i] = ch;
                    String replaced = new String(wordChar);
                    
                    if (st.contains(replaced)) {
                        st.remove(replaced);
                        q.add(new Pair(replaced, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair {
    String first;
    int second;
    
    public Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}
