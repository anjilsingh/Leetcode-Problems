class Solution {
     static class Pair {
        int value;
        int index;

        public Pair(int value, int index)
        {
            this.value = value;
            this.index = index;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
         if(nums.length<k){
             
             return nums;

         }
   
        List<Integer>ans=new ArrayList<>();
       PriorityQueue<Pair> heap = new PriorityQueue<>(
            (a, b) -> b.value - a.value);

        // Initialize the heap with the first k elements
        for (int i = 0; i < k; i++) {
            heap.offer(new Pair(nums[i], i));
        }

        // The maximum element in the first window
        ans.add(heap.peek().value);

        // Process the remaining elements
        for (int i = k; i < nums.length; i++) {
            heap.offer(new Pair(nums[i], i));

            // Remove elements that are outside the current
            // window
            while (heap.peek().index <= i - k) {
                heap.poll();
            }

            // The maximum element in the current window
            ans.add(heap.peek().value);
        }

       
        
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}