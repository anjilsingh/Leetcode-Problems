class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        //now rev each row

        for(int i=0;i<matrix.length;i++){
            int left=0;
            int right=matrix[0].length-1;
            while(left<right){
              int temp=matrix[i][left];
              matrix[i][left]=matrix[i][right];
              matrix[i][right]=temp;
              left++;
              right--;
            }
        }

    }
}