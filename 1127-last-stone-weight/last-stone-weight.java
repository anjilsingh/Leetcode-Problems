class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        for(int stone:stones){
            pq.add(stone);
        }
        while(pq.size()>=2){
            int x=pq.poll();
            int y=pq.poll();
            if(x==y){
                
            }
            else{
                pq.add(x-y);
            }
        }
        return pq.isEmpty()?0:pq.peek();
    }
}