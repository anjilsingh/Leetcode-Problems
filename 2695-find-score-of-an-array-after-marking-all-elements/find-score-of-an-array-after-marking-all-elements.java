class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        long score = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        boolean[] visited = new boolean[n];
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int val = curr[0];
            int index = curr[1];
            if (visited[index])
                continue;
            if (index - 1 >= 0)
                visited[index - 1] = true;
            if (index + 1 < n)
                visited[index + 1] = true;
            score += val;
        }
        return score;
    }
}