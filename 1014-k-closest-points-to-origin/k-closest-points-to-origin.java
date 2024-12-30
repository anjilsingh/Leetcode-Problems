class Solution {
    public int[][] kClosest(int[][] points, int k) {
           PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // Compare distances (b[0]^2 + b[1]^2) - (a[0]^2 + a[1]^2)
            return Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1]));
        });
        for(int point[]:points){
            pq.add(point);
            if(pq.size()>k) pq.poll();
        }

        int[][] output=new int[pq.size()][2];
        int i=0;
        while(!pq.isEmpty()){
            output[i++]=pq.poll();
        }
        return output;
    }
}