class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        
        int vis[]=new int[value];
        for(int it:nums){
            if(it%value<0) vis[(it%value)+value]++;
           else vis[Math.abs(it)%value]++; 
        }
        
        
        int res=0;
        
        while(true){
            
            if(vis[res%value]==0) return res;
            vis[res%value]--;
            res++;
        }
        
        // return -1;
    }
}