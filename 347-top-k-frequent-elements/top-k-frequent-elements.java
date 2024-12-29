class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
       PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
           pq.add(new int[]{entry.getValue(),entry.getKey()});

           if(pq.size()>k){
            pq.poll();
           }
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll()[1];
        }
        return ans;
    }
}