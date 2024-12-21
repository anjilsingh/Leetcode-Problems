class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length-1;
        
        //first search the target row using bs
        int top=0;
        int bot=row-1;
        
       while(top<=bot) {
         int r=(top+bot)/2;
         if(target>matrix[r][col]){
             top=r+1;
         }
         else if(target<matrix[r][0]){
             bot=r-1;
         }
           else {
                break;
           }
       }
        if(top>bot) return false;
        int r=(top+bot)/2;
        
        int left=0;
        int right=col;
        while(left<=right){
          int mid=(left+right)/2;
          if(matrix[r][mid]==target) return true;
          else if(matrix[r][mid]<target) left=mid+1;
          else  right=mid-1;
        }
        return false;
    }
}