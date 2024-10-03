class Solution {
       public int repeatedStringMatch(String A, String B) {
        int count = 1; // Minimum number of times A has to be repeated.
        StringBuilder resStr = new StringBuilder(A);
        
        while (resStr.length() < B.length()) {
            resStr.append(A);
            count++;
        }
        if (resStr.indexOf(B) != -1)
            return count;
       
        resStr.append(A);
        return (resStr.indexOf(B) == -1) ? -1 : count + 1;
    }
}