class Solution {
    int row;
    int col;
    public boolean find(char[][]board,String word,int i,int j,int index){
        if(index==word.length()){
            return true;
        }
        if(i<0||i>=row||j<0||j>=col||board[i][j]!=word.charAt(index)||board[i][j]=='$'){
            return false;
        }
        board[i][j]='$';
        boolean res=(find(board,word,i,j+1,index+1)||find(board,word,i,j-1,index+1)||find(board,word,i-1,j,index+1)||find(board,word,i+1,j,index+1));
        board[i][j]=word.charAt(index);
        return res;
    }
    public boolean exist(char[][] board, String word) {
        row=board.length;
        col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)){
                    if(find(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}