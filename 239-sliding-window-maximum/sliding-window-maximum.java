class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] output=new int[n-k+1];

        PriorityQueue<int[]>maxHeap=new PriorityQueue<>((a,b)->b[1]-a[1]);
         int j=0;
        for(int i=0;i<n;i++){
            maxHeap.add(new int[]{i,nums[i]});
            if(i>=k-1){
                while(maxHeap.peek()[0]<=i-k){
                    maxHeap.poll();
                }
                output[j++]=maxHeap.peek()[1];
            }
           
        }
        return output;
    }
}