class Solution {
    public void dfs(ArrayList<ArrayList<Integer>>adjList,int start,boolean vis[]){
        vis[start]=true;
        for(int neg:adjList.get(start)){
            if(!vis[neg]){
                dfs(adjList,neg,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        ArrayList<ArrayList<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j]==1){
                    adjList.get(i).add(j);
                }
            }
        }
       int count=0;
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
          if(!vis[i]){
            dfs(adjList,i,vis);
            count++;
          }
        }
        return count;
    }
}