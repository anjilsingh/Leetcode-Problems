class Solution {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26]; 
        char ans='a';
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        // Decrease the frequency for characters in ransomNote
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
            // If frequency goes below 0, return false (not enough characters)
          
        }
        for(int i=0;i<26;i++){
            if(arr[i]<0){
                 ans =(char)(i+'a');
            }
        }

       return ans; 
        
    }
}