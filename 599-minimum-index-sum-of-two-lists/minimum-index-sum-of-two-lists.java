class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int lsum = Integer.MAX_VALUE;  // Minimum index sum
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();

        // Add all items from list1 to the map with their index
        for (int i = 0; i < list1.length; i++) {
            mp.put(list1[i], i);
        }

        // Traverse through list2 and check if items are in list1
        for (int i = 0; i < list2.length; i++) {
            if (mp.containsKey(list2[i])) {
                int sum = i + mp.get(list2[i]);
                
                if (sum < lsum) {
                    lsum = sum;
                    ans.clear();  // Clear the list when a smaller index sum is found
                    ans.add(list2[i]);
                } else if (sum == lsum) {
                    ans.add(list2[i]);  // If the same minimum sum is found, add the restaurant
                }
            }
        }

        // Convert the answer list to an array and return
        return ans.toArray(new String[ans.size()]);
    }
}
