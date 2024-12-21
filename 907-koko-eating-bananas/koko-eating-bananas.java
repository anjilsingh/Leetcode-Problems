class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //now instead of this we can use binary search 
        
        int max=piles[0];
        for(int i=0;i<piles.length;i++){
            if(piles[i]>max) max=piles[i];
        }
        int ans=max;
        int left=0;
        int right=max;
        
        while(left<=right){
           int mid=(left+right)/2;
           int total=0;
            for(int i=0;i<piles.length;i++){
              total+=Math.ceil((double)piles[i]/mid);
            }
            if(total>h){
              left=mid+1;
            }
            else{
                ans=mid;
                right=mid-1;
            }
        }
        return ans;
    }
}