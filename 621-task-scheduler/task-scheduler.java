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
        HashMap<Character,Integer>mp=new HashMap<>();
        PriorityQueue<Task>pq=new PriorityQueue<>();
        for(char ch:tasks){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

        for(int frq:mp.values()){
           pq.add(new Task(frq,0));
        }

        Queue<Task>q=new LinkedList<>();
        int time=0;

        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
            Task task=pq.poll();
            int freq=task.freq;
            freq--;
            //decrease freq
            if(freq>0){
                int t=time+n;
                q.add(new Task(freq,t));
            }
            }

            if(!q.isEmpty() && q.peek().exeT<=time){
               pq.add(q.poll());
            }
        }
        return time;
    }
}