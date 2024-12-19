import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            arr.add(new int[]{position[i], speed[i]});
        }

        // Sort based on position in descending order
        arr.sort((a, b) -> b[0] - a[0]);

        Stack<Double> st = new Stack<>();
        for (int[] p : arr) {
            // Calculate time to reach the target
            double time = (double) (target - p[0]) / p[1];
            if (!st.isEmpty() && time <= st.peek()) {
                // Merge fleets if necessary
                continue;
            }
            st.push(time);
        }
        return st.size();
    }
}
