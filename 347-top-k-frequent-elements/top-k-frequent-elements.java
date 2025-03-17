class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        int[] output=new int[k];
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(Map.Entry<Integer,Integer>entry:mp.entrySet()){
            pq.add(new int[]{entry.getValue(),entry.getKey()});
            
        }
        for(int i=0;i<k;i++){
            output[i]=pq.poll()[1];
        }
        return output;

    }
}