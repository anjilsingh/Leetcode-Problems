class Solution {
    public boolean bfs(int curr,int[] color,int[][]graph){
        Queue<Integer>q=new LinkedList<>();
        q.add(curr);
        color[curr]=1;
        while(!q.isEmpty()){
           int node=q.poll();
          for(int neg:graph[node]){
              if(color[neg]==-1){
                q.add(neg);
                color[neg]=1-color[node];
              }
              else if(color[neg]==color[node]){
                 return false;
              }

          }
            
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        int[] color=new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
             if(color[i]==-1){
               if(bfs(i,color,graph)==false) return false;
             }
        }
        return true;
    }
}