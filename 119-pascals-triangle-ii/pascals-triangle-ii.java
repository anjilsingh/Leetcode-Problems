class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        
        // Loop to generate rows up to rowIndex
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            
            // Inner loop to fill each row
            for (int j = 0; j <= i; j++) {
                // First and last elements of each row are 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Sum of the two elements directly above
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            
            // Add the row to the ans list
            ans.add(row);
        }
        
        // Return the row at rowIndex
        return ans.get(rowIndex);
    }
}
