class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        int[] output=new int[k];
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(Map.Entry<Integer,Integer>entry:mp.entrySet()){
            pq.add(new int[]{entry.getValue(),entry.getKey()});
            if(pq.size()>k){
            pq.poll();
            }
        }
        int i=0;
        while(!pq.isEmpty()){
            output[i++]=pq.poll()[1];
        }

     return  output;
    }
}