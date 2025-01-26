class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        //can i use a hashmap to store all zero index
        
        HashMap<Pair,Integer>mp=new HashMap<>();

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
              if(matrix[i][j]==0){
                mp.put(new Pair(i,j),0);
              }
            }
        }

         for (Pair key : mp.keySet()) {
            int row = key.i;
            int col = key.j;

            // Set entire row to zero
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }

            // Set entire column to zero
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}