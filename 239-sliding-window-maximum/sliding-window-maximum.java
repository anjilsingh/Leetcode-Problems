class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] output=new int[nums.length-k+1];
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        int x=0;
        for(int i=0;i<nums.length;i++){
            pq.add(new int[]{i,nums[i]});

            if(i>=k-1){
                while(pq.peek()[0]<=i-k){
                    pq.poll();
                }
                output[x++]=pq.peek()[1];
            }
        }
        return output;
    }
}