class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]>al=new ArrayList<>();
        int[] currInterval=intervals[0];

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=currInterval[1]){
                currInterval[1]=Math.max(currInterval[1],intervals[i][1]);
            }
            else{
                al.add(currInterval);
                currInterval=intervals[i];
            }
        }
        al.add(currInterval);
        return al.toArray(new int[al.size()][2]);


    }
}