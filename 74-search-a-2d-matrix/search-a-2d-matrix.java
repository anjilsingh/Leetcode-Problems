class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length-1;
        int col=matrix[0].length-1;
        int start=0;
        int end=row;
        while(start<=end){
            int mid=(start+end)/2;

            if(target<matrix[mid][0]){
                end=mid-1;
            }
            else if(target>matrix[mid][col]){
                start=mid+1;
            }
            else{
                break;
            }
        }
        if(start>end){
            return false;
        }
        int r=(start+end)/2;
        int left=0;
        int right=col;
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(matrix[r][mid]==target){
                return true;
            }
            else if(matrix[r][mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return false;
    }
}