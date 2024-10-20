class Solution {
    
      public void dfs(int curr,ArrayList<ArrayList<Integer>>adj,boolean[] vis){
        
        vis[curr]=true;
        for(int neg:adj.get(curr)){
            if(!vis[neg]){
                dfs(neg,adj,vis);
            }
        }
        
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        int V=isConnected.length;
        for(int i=0;i<V;i++){
           adj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
          for(int j=0;j<V;j++){
             if(isConnected[i][j]==1 && i!=j){
                adj.get(i).add(j);
             }
          }
        }
        int count=0;
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
           if(!vis[i]){
              dfs(i,adj,vis);
              count++;
           }
        }
        
        return count;
    }
}