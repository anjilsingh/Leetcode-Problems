class Solution {
    public boolean bfs(int curr,int[][]graph,int[] color){

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
   //the graph will ne bipartiate if we can color its nodes such that two adjacent nodes do not contains same color
       int V=graph.length;
       int[] color=new int[V];
       Arrays.fill(color,-1);
     
        for(int i=0;i<V;i++){
          if(color[i]==-1){
             if(bfs(i,graph,color)==false) return false;
              
          }
        }
        return true;
    }
}