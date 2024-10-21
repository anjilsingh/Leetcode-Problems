class Solution {
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
    public int[][] updateMatrix(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
       int[][]dis=new int[row][col];
       int[][]vis=new int[row][col];
        
       Queue<Node>q=new LinkedList<>();
        for(int i=0;i<row;i++){
           for(int j=0;j<col;j++){
            
               if(mat[i][j]==0){
                  dis[i][j]=0;
                 q.add(new Node(i,j,0));
                 vis[i][j]=1;
             
              }
               else{
                vis[i][j]=0;
               }
           }
        }
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        while(!q.isEmpty()){
            
              int r=q.peek().first;
              int c=q.peek().second;
              int steps=q.peek().third;
              q.remove();
              dis[r][c]=steps;
              for(int j=0;j<4;j++){
                  int newr=r+dx[j];
                  int newc=c+dy[j];
         if(newr<0 ||newr>=row ||newc<0 ||newc>=col||vis[newr][newc]==1)continue;
                  
                  q.add(new Node(newr,newc,steps+1));
                  vis[newr][newc]=1;
              }
        }
        return dis;

    
    }
}