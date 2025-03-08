class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] output=new int[n-k+1];
        int j=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<n;i++){
            pq.add(new int[]{nums[i],i});

            if(i>=k-1){
                while(pq.peek()[1]<=i-k){
                    pq.poll();
                }

                output[j]=pq.peek()[0];
                j++;
            }
        }
        return output;
    }
}