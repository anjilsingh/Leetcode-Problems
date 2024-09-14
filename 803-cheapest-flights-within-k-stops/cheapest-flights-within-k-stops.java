class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Tuple {
    int first, second, third; 
    Tuple(int first, int second, int third) {
        this.first = first; 
        this.second = second;
        this.third = third; 
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
 ArrayList<ArrayList<Pair>> adj = new ArrayList<>(); 
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>()); 
        }
        int m = flights.length; 
        for(int i = 0;i<m;i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2])); 
        }
          
Queue<Tuple>q=new LinkedList<>();
q.add(new Tuple(0,src,0));
        
        int[] dis=new int[n];
        for(int i=0;i<n;i++){
           dis[i]=(int)1e9;
        }
        dis[src]=0;
        while(!q.isEmpty()){
            Tuple it=q.peek();
            q.remove();
            int steps=it.first;
            int node=it.second;
            int cost=it.third;
            
           if(steps>k) continue;
            
            for(Pair neb:adj.get(node))            {
              
              int adjNode = neb.first; 
                int edW = neb.second; 
                
                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if (cost + edW < dis[adjNode] && steps <= k) {
                    dis[adjNode] = cost + edW; 
                    q.add(new Tuple(steps + 1, adjNode, cost + edW)); 
                }
            }
        }
        //finally
        if(dis[dst]==1e9){
          return -1;
        }
      
        return dis[dst];
        
    }
}