class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //closet so we have to create max heap
        
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(b[0]*b[0]+b[1]*b[1],a[0]*a[0]+a[1]*a[1]);
        });


        for(int[] point:points){
            pq.add(point);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[][] output=new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            output[i++]=pq.poll();
        }
        return output;
    }
}