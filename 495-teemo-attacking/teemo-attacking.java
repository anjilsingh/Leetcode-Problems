class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
         
        int n=timeSeries.length;
        int maxDuration=0;
        for(int i=0;i<n-1;i++){
             int diff=timeSeries[i+1]-timeSeries[i];
             maxDuration+=Math.min(diff,duration);
        }
        maxDuration+=duration;
        return maxDuration;
    }
}