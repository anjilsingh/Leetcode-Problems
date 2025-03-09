class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //find the max \
        //apply binary search between 0 to that max

        int max=piles[0];
        for(int i=1;i<piles.length;i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }
        int ans=max;
        int start=1;
        int end=max;

        while(start<=end){
            int mid=start+(end-start)/2;
            double time=0;
            for(int i=0;i<piles.length;i++){
                time+=Math.ceil((double)piles[i]/mid);
            }
            if(time<=h){
                ans=mid;
                end=mid-1;

            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}