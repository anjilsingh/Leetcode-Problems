class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    
        //no of rows and coulmns 
        int row=matrix.length;
        int col=matrix[0].length;
       
        int top=0;
        int bot=row-1;
        while(top<=bot){
            int r=(top+bot)/2;
            if(matrix[r][col-1]<target){
               top=r+1;
            }
            else if(matrix[r][0]>target){
               bot=r-1;
            }
            else{
               break;
            }
        }
        
        if(!(top<=bot)) return false;
        
        int nrow=(top+bot)/2;
        int left=0;
        int right=col-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(matrix[nrow][mid]==target) return true;
            else if(matrix[nrow][mid]<target){
                   left=mid+1;
            }
            else{
                right=mid-1;
            }

        }
        return false;
    }
}