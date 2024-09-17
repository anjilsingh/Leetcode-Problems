

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Step 1: Split both sentences into words
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        
        // Step 2: Create two HashMaps to store word frequencies for each sentence
        HashMap<String, Integer> wordCount1 = new HashMap<>();
        HashMap<String, Integer> wordCount2 = new HashMap<>();
        
        // Step 3: Count occurrences of words in both sentences separately
        for (String word : words1) {
            wordCount1.put(word, wordCount1.getOrDefault(word, 0) + 1);
        }
        
        for (String word : words2) {
            wordCount2.put(word, wordCount2.getOrDefault(word, 0) + 1);
        }
        
        // Step 4: Collect uncommon words
        List<String> uncommonWords = new ArrayList<>();
        
        // Uncommon words from the first sentence
        for (String word : wordCount1.keySet()) {
            if (wordCount1.get(word) == 1 && !wordCount2.containsKey(word)) {
                uncommonWords.add(word);
            }
        }
        
        // Uncommon words from the second sentence
        for (String word : wordCount2.keySet()) {
            if (wordCount2.get(word) == 1 && !wordCount1.containsKey(word)) {
                uncommonWords.add(word);
            }
        }
        
        // Step 5: Convert the list to an array and return
        return uncommonWords.toArray(new String[0]);
    }
}
