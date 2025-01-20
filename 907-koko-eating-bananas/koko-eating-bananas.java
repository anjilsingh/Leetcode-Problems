class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=piles[0];
        for(int i=1;i<piles.length;i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }

        int low=0;
        int high=max;
        int ans=max;

        while(low<=high){
            int mid=(low+high)/2;
            double req=0;
            for(int i=0;i<piles.length;i++){
               req+=Math.ceil((double)piles[i]/mid);
            }
            if(req>h){
                low=mid+1;
            }
            else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
}