class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //since we have to find the frequency we can use a hasmap for this 

        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(Map.Entry<Integer,Integer>entry:mp.entrySet()){
            pq.add(new int[]{entry.getValue(),entry.getKey()});
        }

        while(pq.size()>k){
            pq.poll();
        }

        int[] res=new int[k];
        int x=0;
        while(!pq.isEmpty()){
            res[x]=pq.poll()[1];
            x++;

        }
        return res;
    }
}