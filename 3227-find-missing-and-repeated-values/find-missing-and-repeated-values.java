class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];  // ans[0] will store the repeated element, ans[1] will store the missing element
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n=grid.length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               mp.put(grid[i][j], mp.getOrDefault(grid[i][j], 0) + 1);
            }
        }
        // // Populate the HashMap with the frequency of each element in the array
        // for (int i = 0; i < arr.length; i++) {
        //     mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        // }

        // Find the repeated and missing element
        for (int i = 1; i <= n*n; i++) {
            // Check if the element is repeated (frequency == 2)
            if (mp.getOrDefault(i, 0) == 2) {
                ans[0] = i;  // Repeated element
            }
            // Check if the element is missing (frequency == 0)
            if (mp.getOrDefault(i, 0) == 0) {
                ans[1] = i;  // Missing element
            }
        }
        
        return ans; 
    }
}