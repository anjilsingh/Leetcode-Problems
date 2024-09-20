class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        // Outer loop for rows
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            // Inner loop for columns in each row
            for (int j = 0; j <= i; j++) {
                // First and last element in each row is always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Sum of the two elements directly above
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            
            // Add row to the result
            ans.add(row);
        }
        
        return ans;
    }
}
