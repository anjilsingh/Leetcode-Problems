import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Initialize the result list
        List<List<Integer>> ans = gss(nums, 0);
        return ans;
    }

    public static List<List<Integer>> gss(int[] nums, int i) {
        // Base case: when i reaches the end of nums array
        if (i == nums.length) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());  // Add an empty list, not a list with a string
            return ans;
        }

        // Get the current element (first digit)
        int fd = nums[i];

        // Recursive call for the rest of the array
        List<List<Integer>> roarr = gss(nums, i + 1);

        // Create a new list to store the final subsets
        List<List<Integer>> myarr = new ArrayList<>();

        // Loop through each subset from the recursive call
        for (List<Integer> list : roarr) {
            // Add the current subset to myarr
            myarr.add(new ArrayList<>(list));

            // Create a copy of the subset, add the current element (fd), and add it to myarr
            List<Integer> newList = new ArrayList<>(list);
            newList.add(fd);
            myarr.add(newList);
        }

        return myarr;
    }
}
