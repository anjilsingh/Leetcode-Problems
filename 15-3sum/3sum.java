class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Sort the array to handle duplicates easily later
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the current number
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int target = -nums[i];
            HashMap<Integer, Integer> map = new HashMap<>();
            
            for (int j = i + 1; j < nums.length; j++) {
                int complement = target - nums[j];
                
                // Check if the complement exists in the map
                if (map.containsKey(complement)) {
                    result.add(Arrays.asList(nums[i], nums[j], complement));
                    
                    // Skip duplicates for the second number
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
                }
                
                // Add the current number to the map
                map.put(nums[j], j);
            }
        }
        
        return result;
    }
}