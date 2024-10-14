class Solution {
    public int climbStairs(int n) {
     int[] qb=new int[n+1];
     int ans=countPaths(n,qb);
     return ans;
        
    }
    
    public int countPaths(int n,int[] qb){
       if(n==0){
           return 1;
        }
        else if(n<0){
          return 0;
        }
        if(qb[n]>0){
           return qb[n];
        }
        
        int m1=countPaths(n-1,qb);
        int m2=countPaths(n-2,qb);
        
        int ans=m1+m2;
        qb[n]=ans;
        return ans;
    }
}