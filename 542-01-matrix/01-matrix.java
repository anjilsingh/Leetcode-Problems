class Node {
    int first;
    int second;
    int third; 
    Node(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int vis[][]=new int[n][m];
        int dist[][]=new int[n][m];
        
        Queue<Node>q=new LinkedList<>();
        for(int i=0;i<n;i++){

           for(int j=0;j<m;j++){
               if(mat[i][j]==0){
                   q.add(new Node(i,j,0));
                   vis[i][j]=1;
               }
               else{
                  vis[i][j]=0;
               }
           }
        }
        while(!q.isEmpty()){
            
        int nn=q.peek().first;
        int mm=q.peek().second;
        int step=q.peek().third;
         q.poll(); 
        dist[nn][mm]=step;
        int[] delrow={-1,1,0,0};
        int[] delcol={0,0,-1,1};
        
        for(int i=0;i<4;i++){
              int row=delrow[i]+nn;
             int col=delcol[i]+mm;
            
            if(row>=0 && row<n && col>=0 && col<m && vis[row][col]==0){

               q.add(new Node(row,col,step+1));
                
                vis[row][col]=1;
            }
        
        
        }
        
        } 
        return dist;
        
      
        
    }
}