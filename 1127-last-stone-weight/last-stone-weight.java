class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        for(int stone:stones){
            pq.add(stone);
        }

        while(pq.size()>=2){
            int lar=pq.poll();
            int slar=pq.poll();
            if(lar==slar){

            }
            else{
                  pq.add(lar-slar);
            }
        }
        if(pq.isEmpty()) return 0;
        else return pq.peek();
    }
}