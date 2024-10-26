class Solution {
    public int makeConnected(int n, int[][] connections) {
        //no of parents that are parent to itself are the no of connected components
        
        
        //step 1 no of edges less < n-1 then return false;
        //for every edges we will caluclate the find union which give the ultimate parent 
        //for every connected pair therre will one ultimate aprent so no of up will be equal to ultimate componetns
        
        
        if(connections.length<n-1) return -1;
        int[] parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int[] edges:connections){
           int u=edges[0];
           int v=edges[1];
           union(parent,u,v);
        }
        
        int count=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i){
              count++;
            }
        }
        return count-1;
        
    }
    
    public static void union(int[] parent ,int u,int v){
         int ulp_u=findParent(parent,u);
         int  ulp_v=findParent(parent,v);
        parent[ulp_u]=ulp_v;
    }
    public static int findParent(int[] parent ,int u){
       if(parent[u]!=u){
           parent[u]=findParent(parent,parent[u]);
       }
        return parent[u];
    }
    
}