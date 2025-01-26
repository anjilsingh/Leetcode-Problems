class Solution {
    public void rotate(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;

        for(int i=0;i<row;i++){
            for(int j=i;j<col;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        //now rev the each row 

         for(int r[]:matrix){
            int left=0;
            int right=col-1;
            while(left<right){
                int temp=r[left];
                r[left]=r[right];
                r[right]=temp;
                left++;
                right--;
            }
        }



    }
}