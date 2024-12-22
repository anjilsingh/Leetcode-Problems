class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=piles[0];
        for(int i=0;i<piles.length;i++){
            if(piles[i]>max) max=piles[i];
        }
        
        //now linear serach from 1 tp max
        int ans=max;
        int low=0;
        int high=max;
        while(low<=high){
            int mid=(low+high)/2;
            int  total=0;
            for(int j=0;j<piles.length;j++){
              total+=Math.ceil((double)piles[j]/mid);
            }
            if(total<=h){
              ans=mid;
             high=mid-1;
            }
            else{
              low=mid+1;
            }
        }
        return ans;
        
    }
}