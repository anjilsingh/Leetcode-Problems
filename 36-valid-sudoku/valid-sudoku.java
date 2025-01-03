class Solution {
    public boolean isValid(int row,int col,char[][]board){
      HashSet<Character>seen=new HashSet<>();
      for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            if(board[i+row][j+col]=='.') continue;
            else {
                if(seen.contains(board[row+i][col+j])) return false;
                seen.add(board[row+i][col+j]);
            }
        }
      }
      return true;
    }
    public boolean isValidSudoku(char[][] board) {
        
     //check for row
     for(int i=0;i<9;i++){
        HashSet<Character>seen=new HashSet<>();
        for(int j=0;j<9;j++){
            if(board[i][j]=='.') continue;
            else{
                if(seen.contains(board[i][j])) return false;
                seen.add(board[i][j]);
            }
        }
     }
     for(int i=0;i<9;i++){
        HashSet<Character>seen=new HashSet<>();
        for(int j=0;j<9;j++){
            if(board[j][i]=='.') continue;
            else{
                if(seen.contains(board[j][i])) return false;
                seen.add(board[j][i]);
            }
        }
     }

     for(int i=0;i<9;i=i+3){
        for(int j=0;j<9;j=j+3){
           // if(!isValid(i,j,board)) return false;

          // return isValid(i,j,board):true?false;
          if(isValid(i,j,board)==false){
            return  false;
          }
        }
     }
     return true;
    }
}