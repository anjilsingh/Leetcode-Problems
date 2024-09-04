class Solution {
    private void dfs(int r,int c,int[] delRow,int[] delCol,int[][]vis,char[][]board,int n,int m){
        
        vis[r][c]=1;

        for(int i=0;i<4;i++)
        {
             int row=r+delRow[i];
             int col=c+delCol[i];
            
     if(row>=0 && row<n && col>=0 && col<m && vis[row][col]==0 && board[row][col]=='O'){

                   dfs(row,col,delRow,delCol,vis,board,n,m);
              }
                 
        
        
        
        }
    
    
    
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int delRow[]={0,0,-1,1};
        int delCol[]={1,-1,0,0};
        int vis[][]=new int[n][m];
        
        //check for rows
        
        for(int j=0;j<m;j++){
            if(vis[0][j]==0 && board[0][j]=='O'){

               dfs(0,j,delRow,delCol,vis,board,n,m);
            }
            
            if(vis[n-1][j]==0 && board[n-1][j]=='O'){
                dfs(n-1,j,delRow,delCol,vis,board,n,m);
            }
        
        }
        
        //check for cols
        
        for(int i=0;i<n;i++){
          if(vis[i][0]==0 && board[i][0]=='O'){
              dfs(i,0,delRow,delCol,vis,board,n,m);
          }
            
            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
              dfs(i,m-1,delRow,delCol,vis,board,n,m);
          }
        }
        
        //convert remaining 'O' to 'X'
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){

                     board[i][j]='X';
                }
            }
        }
    }
}