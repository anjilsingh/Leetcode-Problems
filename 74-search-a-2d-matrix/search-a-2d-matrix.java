class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row=matrix.length-1;
        int col=matrix[0].length-1;
        
        int top=0;
        int bot=row;
        while(top<=bot){
            int mid=(top+bot)/2;
            if(target<matrix[mid][0]) {
             bot=mid-1;
            }
            else if(target>matrix[mid][col]){
              top=mid+1;
            }
            else{
              break;
            }
        }
     
        if(bot<top){
            return false;
        }
        int ro=(top+bot)/2;
        
        int l=0;
        int r=col;
        while(l<=r){
           int mid=(l+r)/2;
            if(matrix[ro][mid]==target) return true;
            else if(matrix[ro][mid]<target) l=mid+1;
            else r=mid-1;
        }
        return false;
    }
}