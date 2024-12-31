class Task implements Comparable<Task> {
    public int freq;
    public int exeT;

    public Task(int f, int e) {
        freq = f;
        exeT = e;
    }

    @Override
    public int compareTo(Task that) {
        return that.freq - this.freq; // Max-Heap behavior
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (char ch : tasks) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Task> pq = new PriorityQueue<>();
        for (Character ch : mp.keySet()) {
            pq.add(new Task(mp.get(ch), 0));
        }

        Queue<Task> q = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                Task task = pq.poll();
                task.freq--;

                if (task.freq > 0) {
                    task.exeT = time + n;
                    q.offer(task);
                }
            }

            if (!q.isEmpty() && q.peek().exeT <= time) {
                pq.add(q.poll());
            }
        }

        return time;
    }
}
