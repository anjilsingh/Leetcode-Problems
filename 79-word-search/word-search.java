class Solution {
    public boolean dfs(char[][] board, int i,int j,int row,int col,String word,int index){
        if(index==word.length()){
            return true;
        }
        if(i<0 ||j<0 ||i>=row||j>=col||board[i][j]=='$' ||board[i][j]!=word.charAt(index))  {
            return false;
        }
        board[i][j]='$';
        boolean res=(dfs(board,i+1,j,row,col,word,index+1)||dfs(board,i,j+1,row,col,word,index+1) ||dfs(board,i-1,j,row,col,word,index+1)||dfs(board,i,j-1,row,col,word,index+1));
        board[i][j]=word.charAt(index);
        return res;
    }
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,i,j,row,col,word,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}