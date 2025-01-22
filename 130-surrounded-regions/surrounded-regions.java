class Solution {
    public void solve(char[][] board) {
        
        //need to find all boundary o and find if there is any connected 0 with that if yes than for that it is not poosible else all will be "X";


        boolean[][] vis=new boolean[board.length][board[0].length];

        Queue<int[]>q=new LinkedList<>();

        // for(int i=0;i<board.length;i++){
        //     for(int j=0;j<board[0].length;j++){
        //         if(board[i][j]=='0'){
        //             q.add(new int[]{i,j});
        //             vis[i][j]=true;
        //         }
        //     }
        // }


        //only add boundary ele

        for(int col=0;col<board[0].length;col++){
            if(board[0][col]=='O'){
                q.add(new int[]{0,col});
                vis[0][col]=true;
            }
            if(board[board.length-1][col]=='O'){
               q.add(new int[]{board.length-1,col});
               vis[board.length-1][col]=true;
            }
        }
        for(int row=0;row<board.length;row++){
            if(board[row][0]=='O'){
                q.add(new int[]{row,0});
                vis[row][0]=true;
            }

            if(board[row][board[0].length-1]=='O'){
                q.add(new int[]{row,board[0].length-1});
                vis[row][board[0].length-1]=true;
            }
        }

        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        while(!q.isEmpty()){
        
                int[] node=q.poll();
                int r=node[0];
                int c=node[1];

                for(int j=0;j<4;j++){
                    int newR=r+dx[j];
                    int newC=c+dy[j];

    if(newR<0||newR>=board.length||newC<0 ||newC>=board[0].length||board[newR][newC]=='X'||vis[newR][newC]==true) {
                    continue;
                 }
                    else{
                        q.add(new int[]{newR,newC});
                        vis[newR][newC]=true;
                    }
                 }
            
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X') continue;
                if(board[i][j]=='O' && vis[i][j]==false){
                    board[i][j]='X';
                }
            }
        }
       // return board;
    }
}