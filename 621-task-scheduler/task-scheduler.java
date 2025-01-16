class Solution {
    class Task implements Comparable<Task> {
        int freq; // Frequency of the task
        int exeT; // Next eligible execution time
        
        Task(int freq, int exeT) {
            this.freq = freq;
            this.exeT = exeT;
        }
        
        public int compareTo(Task that) {
            return that.freq - this.freq; // Max-Heap based on frequency
        }
    }
    
    public int leastInterval(char[] tasks, int n) {
        // Count frequencies of tasks
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : tasks) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Priority queue for the max-heap (by frequency)
        PriorityQueue<Task> pq = new PriorityQueue<>();
        for (int freq : freqMap.values()) {
            pq.add(new Task(freq, 0)); // Initialize tasks with 0 execution time
        }

        int time = 0; // Keep track of the current time
        Queue<Task> cooldown = new LinkedList<>(); // Queue for cooling tasks

        while (!pq.isEmpty() || !cooldown.isEmpty()) {
            time++; // Increment time at each step
            
            // Process tasks from the max-heap
            if (!pq.isEmpty()) {
                Task current = pq.poll();
                current.freq--; // Decrease frequency
                if (current.freq > 0) {
                    current.exeT = time + n; // Update next eligible time
                    cooldown.add(current); // Add to cooldown queue
                }
            }
            
            // Check if tasks in the cooldown queue are ready
            if (!cooldown.isEmpty() && cooldown.peek().exeT <= time) {
                pq.add(cooldown.poll()); // Re-insert back into the priority queue
            }
        }

        return time; // Total time taken
    }
}
