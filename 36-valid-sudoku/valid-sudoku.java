class Solution {
    public boolean isValid(char[][] board,int row,int col){
        HashSet<Character>seen=new HashSet<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                char ch=board[row+i][col+j];
                if(ch=='.') continue;
                if(seen.contains(ch)){
                    return false;
                }
                seen.add(ch);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        
        //validate all rows
        for(int i=0;i<9;i++){
            HashSet<Character>seen=new HashSet<>();
            for(int j=0;j<9;j++){
                char ch=board[i][j];
                if(ch=='.') {
                    continue;
                }
                else{
                    if(seen.contains(ch)) return false;

                    seen.add(ch);
                }
            }

        }

        //validate all cols
           for(int i=0;i<9;i++){
            HashSet<Character>seen=new HashSet<>();
            for(int j=0;j<9;j++){
                char ch=board[j][i];
                if(ch=='.') {
                    continue;
                }
                else{
                    if(seen.contains(ch)) return false;

                    seen.add(ch);
                }
            }
            
        }
        //validate all 3*3 matrix


        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){

                if(isValid(board,i,j)==false){
                    return false;
                }
            }
        }
        return true;
    }
}