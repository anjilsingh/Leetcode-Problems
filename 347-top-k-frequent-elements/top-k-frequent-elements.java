class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(Map.Entry<Integer,Integer>entry:mp.entrySet()){
            pq.add(new int[]{entry.getValue(),entry.getKey()});
        }
        int[] output=new int[k];
        for(int i=0;i<k;i++){
            output[i]=pq.poll()[1];
        }
        return output;
    }
}