class Solution {
       public boolean isValid( char[][] board,int r ,int c) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[r + i][c + j] == '.') continue;
                else {
                    if (hs.contains(board[r + i][c + j])) return false;
                    else {
                        hs.add(board[r + i][c + j]);
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        
        //so first we need to check for rows
        //then check for cols
        //then all 3*3 matrix
        
        for(int i=0;i<9;i++){
          HashSet<Character>seen=new HashSet<>();
          for(int j=0;j<9;j++){
              if(board[i][j]=='.') continue;
              else{ 
                 if(seen.contains(board[i][j])) return false;
                 else{
                     seen.add(board[i][j]);
                 }
              }
          }
        }
        
           for(int i=0;i<9;i++){
          HashSet<Character>seen=new HashSet<>();
          for(int j=0;j<9;j++){
              if(board[j][i]=='.') continue;
              else{ 
                 if(seen.contains(board[j][i])) return false;
                 else{
                     seen.add(board[j][i]);
                 }
              }
          }
        }
        
        //now check for all 3*3 matrix
        
        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
             if(!isValid(board,i,j)) return false;
            }
        }
        return true;
        
    }
}