class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      // so we know that the h will be always greater then the 
    // length of piles
        
        //we can iterate from 1 to max
        
        int max=piles[0];
        for(int i=1;i<piles.length;i++){
            
            if(piles[i]>max){
                max=piles[i];

             }
        }
        int res=max;
        int left=0;
        int right=max;
        
        while(left<=right){
            int mid=(left+right)/2;
            
            int sum=0;
            for(int j=0;j<piles.length;j++){
                sum+=Math.ceil((double)piles[j]/mid);

            }
            if(sum<=h){
                res=mid;
                right=mid-1;

            }
            else if(sum>h){
               left=mid+1;
            }

        }
        return res;
//         for(int i=1;i<max;i++){
//               int sum=0;
//             for(int j=0;j<piles.length;j++){
//               sum+=Math.ceil((double)piles[j]/i);

//             }
//             if(sum<=h){
//                res=i;
//                return res;
//             }

//         }
//         return res;
    }
}