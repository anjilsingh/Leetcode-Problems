import java.util.*;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //find the max and run a bs from 1 to max of element try to find the min possible4
        int max=piles[0];
        int n=piles.length;
        for(int i=1;i<n;i++){
            if(piles[i]>max){
                 max=piles[i];
            }
        }

        int low=0;
        int high=max;
        int ans=max;
        while(low<=high){
            int mid=(low+high)/2;

            double time=0;
            for(int i=0;i<piles.length;i++){
                time+=Math.ceil((double)piles[i]/mid);
            }
            if(time<=h){
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