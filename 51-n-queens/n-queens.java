class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>res=new ArrayList<>();
       char[][] board=new char[n][n];
       for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            board[i][j]='.';
        }
       }  
       solve(0,res,board);
       return res;


    }

    public void solve(int row,List<List<String>>res,char[][] board){
        if(row==board.length){
            List<String>curr=new ArrayList<>();
            for(char[] r:board){
                curr.add(new String(r));
               
            }
          res.add(curr);
          return;
        }

        for(int j=0;j<board.length;j++){
            if(isValid(board,row,j)){
                board[row][j]='Q';
                solve(row+1,res,board);
                board[row][j]='.';
            }
        }
    }

   public boolean isValid(char[][] board, int r, int c) {
    // Check for any queen in the same column above
    for (int i = r - 1; i >= 0; i--) {
        if (board[i][c] == 'Q') return false;
    }

    // Check for upper-left diagonal
    for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] == 'Q') return false;
    }

    // Check for upper-right diagonal
    for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
        if (board[i][j] == 'Q') return false;
    }

    return true; // If no conflict, return true
}
}
