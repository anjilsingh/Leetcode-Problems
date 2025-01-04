class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if(n==0||k==0) return new int[0] ;
        int[] output=new int[n-k+1];
        Deque<Integer>dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            //remove out of bound ele
            while(dq.size()>0 && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(dq.size()>0 && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                output[i-k+1]=nums[dq.peekFirst()];
            }
        }
        return output;
    }
}