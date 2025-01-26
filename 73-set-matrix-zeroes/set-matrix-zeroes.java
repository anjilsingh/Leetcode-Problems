class Solution {
    public void setZeroes(int[][] matrix) {
        
        //first try to put first row and first col as that extra arr which we have used for that ques

        boolean fRow=false;
        boolean fCol=false;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){

                if(matrix[i][j]==0){
                    if(i==0){
                        fRow=true;
                    }
                    if(j==0){
                        fCol=true;
                    }
                    //mark first row and first col as zero
                    matrix[0][j]=0;
                    matrix[i][0]=0;

                }
            }
        }

       //iterate in interna matrix and set 

       for(int i=1;i<matrix.length;i++){
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j]==0 ||matrix[i][0]==0){
                matrix[i][j]=0;
            }
        }
       } 

       //finally just make first row and first col zero 

       if(fRow){
         for(int i=0;i<matrix[0].length;i++){
            matrix[0][i]=0;
         }
       }
       if(fCol){
        for(int i=0;i<matrix.length;i++){
            matrix[i][0]=0;
        }
       }
    }
}