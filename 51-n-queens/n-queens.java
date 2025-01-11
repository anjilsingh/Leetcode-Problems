class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        solve(0,board,ans);
        return ans;
    }

    public void solve(int r,char[][]board,List<List<String>>ans){
        if(r==board.length){
            List<String>copy=new ArrayList<>();
            for(char[] currRow:board){
                copy.add(new String(currRow));
            }
            ans.add(copy);
            return;
        }
        for(int i=0;i<board.length;i++){
            if(isValid(board,r,i)){
                board[r][i]='Q';
                solve(r+1,board,ans);
                board[r][i]='.';
            }
        }
    }
    public boolean isValid(char[][]board,int r,int c){
        //check foward above

        for(int i=r-1;i>=0 ;i--){
            if(board[i][c]=='Q') return false;
        }
        //chek diagonal
        for(int i=r-1,j=c-1;i>=0 &&j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        for(int i=r-1 , j=c+1 ;i>=0 &&j<board[0].length;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
}