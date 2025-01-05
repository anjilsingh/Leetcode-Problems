

class Solution {

    private void solve(int index, int[] nums, List<List<Integer>> ans, List<Integer> currentSet) {
        if (index == nums.length) {
            ans.add(currentSet); // Add the current subset to the result
            return;
        }

        // Exclude the current element and move to the next index
        solve(index + 1, nums, ans, new ArrayList<>(currentSet));

        // Include the current element and move to the next index
        currentSet.add(nums[index]);
        solve(index + 1, nums, ans, new ArrayList<>(currentSet));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, ans, new ArrayList<>());
        return ans;
    }
}
