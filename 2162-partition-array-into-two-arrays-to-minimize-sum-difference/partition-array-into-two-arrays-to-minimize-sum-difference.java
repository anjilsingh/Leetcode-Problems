import java.util.*;

public class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length, sum = 0;
        sum = Arrays.stream(nums).sum(); // To find the total sum of the array
        
        int N = n / 2; // Divide it into two equal parts
        List<List<Integer>> left = new ArrayList<>(N + 1), right = new ArrayList<>(N + 1);
        
        // Initialize lists for each possible number of elements chosen
        for (int i = 0; i <= N; i++) {
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }
        
        // Generate all possible sums using BIT masking for the left and right halves
        for (int mask = 0; mask < (1 << N); ++mask) {  // (1 << N) = 2^N
            int idx = 0, l_sum = 0, r_sum = 0;
            for (int i = 0; i < N; ++i) {
                if ((mask & (1 << i)) != 0) {  // If bit is set, we add that element
                    idx++;
                    l_sum += nums[i];
                    r_sum += nums[i + N];
                }
            }
            left.get(idx).add(l_sum);
            right.get(idx).add(r_sum);  // Store sums
        }
        
        // Sort the right half for binary search
        for (int idx = 0; idx <= N; ++idx) {
            Collections.sort(right.get(idx));
        }
        
        // To get the minimum difference starting from the max sums from both parts
        int res = Math.min(Math.abs(sum - 2 * left.get(N).get(0)), Math.abs(sum - 2 * right.get(N).get(0)));
        
        // Iterating over the left part
        for (int idx = 1; idx < N; ++idx) {  // Start from 1 and check all except the last (already considered)
            for (int a : left.get(idx)) {
                int b = (sum - 2 * a) / 2;  // Value we want to minimize
                int rightIdx = N - idx;
                List<Integer> v = right.get(rightIdx);  // Get the corresponding right list
                
                // Perform binary search in the sorted right list
                int pos = Collections.binarySearch(v, b);
                
                if (pos < 0) {
                    pos = -(pos + 1); // If not found, pos will be insertion point (-(insertion point) - 1)
                }
                
                // Check current and previous elements (if applicable)
                if (pos < v.size()) {
                    res = Math.min(res, Math.abs(sum - 2 * (a + v.get(pos))));
                }
                if (pos > 0) {
                    res = Math.min(res, Math.abs(sum - 2 * (a + v.get(pos - 1))));
                }
            }
        }
        
        return res;
    }
}
