import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // Sort children's greed factors
        Arrays.sort(s); // Sort cookie sizes
        
        int i = 0, j = 0; // i for children, j for cookies
        int count = 0;
        
        // Loop through both arrays to maximize the number of content children
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) { // If cookie can satisfy child
                count++;        // Increment count of content children
                i++;            // Move to the next child
            }
            j++;                // Move to the next cookie
        }
        
        return count; // Return the number of content children
    }
}
