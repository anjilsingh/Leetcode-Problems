class Solution {
    public int findJudge(int n, int[][] trust) {
        // If there's only one person and no trust relationships, that person is the judge
        if (n == 1 && trust.length == 0) {
            return 1;
        }

        // Create arrays to track the number of people each person trusts and is trusted by
        int[] trustCount = new int[n + 1];
        int[] trustedBy = new int[n + 1];

        // Iterate through the trust array and update trust and trusted counts
        for (int[] t : trust) {
            int a = t[0]; // person a trusts
            int b = t[1]; // person b is trusted by a
            trustCount[a]++;    // a trusts someone
            trustedBy[b]++;     // b is trusted by someone
        }

        // Find the person who is trusted by everyone else but trusts no one
        for (int i = 1; i <= n; i++) {
            if (trustedBy[i] == n - 1 && trustCount[i] == 0) {
                return i; // This person is the judge
            }
        }

        return -1; // If no judge is found
    }
}
