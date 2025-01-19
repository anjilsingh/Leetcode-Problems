class Solution {
    public boolean isValid(int r,int c,char[][]board){
        HashSet<Character>seen=new HashSet<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                char ch=board[r+i][c+j];
                if(ch=='.') continue;
             
                    if(seen.contains(ch)) return false;
                    seen.add(ch);
                
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        
        //we need to check for all rows
        //for all cols 
        //and for all 3*3 grid 

        for(int i=0;i<9;i++){
            HashSet<Character>set=new HashSet<>();
            for(int j=0;j<9;j++){
                char ch=board[i][j];
                if(ch=='.') continue;
                
                    if(set.contains(ch)) return false;
                    set.add(ch);
                
            }
        }

        for(int i=0;i<9;i++){
            HashSet<Character>set=new HashSet<>();
            for(int j=0;j<9;j++){
                    char ch=board[j][i];
                     if(ch=='.') continue;
                    if(set.contains(ch)) return false;
                    set.add(ch);
                
            }
        }

        //now check for all 3*3

        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
                if(isValid(i,j,board)==false) return false;
            }
        }

        return true;
    }
}