class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer>mp=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
          mp.put(tasks[i],mp.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>((a,b)->b-a);
        for(int freg:mp.values()){
                maxHeap.offer(freg);
        }
        int intervals=0;
        while(!maxHeap.isEmpty()){
            int count=0;
            List<Integer>temp=new ArrayList<>();
            for(int i=0;i<=n;i++){
              if (!maxHeap.isEmpty()){

                temp.add(maxHeap.poll());
                count++;
              }                            
            }
            
            for(int freq:temp){
                if(freq-1>0){
                   maxHeap.offer(freq-1);
                }

            }
            
            intervals+=!maxHeap.isEmpty()?n+1:count;
            
            
        }
        return intervals;
    }
}